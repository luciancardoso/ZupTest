package com.zuptest.ZupTest.service;

import com.zuptest.ZupTest.dto.MessageResponseDTO;
import com.zuptest.ZupTest.dto.UsuarioDTO;
import com.zuptest.ZupTest.entity.Usuario;
import com.zuptest.ZupTest.exception.UsuarioNotFoundException;
import com.zuptest.ZupTest.mapper.UsuarioMapper;
import com.zuptest.ZupTest.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper = UsuarioMapper.INSTANCE;

    public MessageResponseDTO createUsuario(UsuarioDTO usuarioDTO){
        Usuario usuarioToSave = usuarioMapper.toModel(usuarioDTO);
        Usuario savedUsuario = usuarioRepository.save(usuarioToSave);

        return createMessageResponse(savedUsuario.getId(), "Created usuario with ");
    }

    public List<UsuarioDTO> listAll(){
        List<Usuario> allUsuario = usuarioRepository.findAll();
        return allUsuario.stream().map(usuarioMapper::toDTO).collect(Collectors.toList());
    }

    public UsuarioDTO findById(Long id) throws UsuarioNotFoundException{
        Usuario usuario = verifyIfExists(id);
        return usuarioMapper.toDTO(usuario);
    }

    public MessageResponseDTO updateById(Long id, UsuarioDTO usuarioDTO) throws UsuarioNotFoundException {
        verifyIfExists(id);

        Usuario usuarioToUpdate = usuarioMapper.toModel(usuarioDTO);
        Usuario updateUsuario = usuarioRepository.save(usuarioToUpdate);
        return createMessageResponse(updateUsuario.getId(), "Update usuario with ID ");
    }

    public void deleteById(Long id) throws UsuarioNotFoundException{
        verifyIfExists(id);
        usuarioRepository.deleteById(id);
    }

    private Usuario verifyIfExists(Long id) throws UsuarioNotFoundException {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message){
        return MessageResponseDTO.builder().message(message + id).build();
    }

}
