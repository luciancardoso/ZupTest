package com.zuptest.ZupTest.controller;

import com.zuptest.ZupTest.dto.MessageResponseDTO;
import com.zuptest.ZupTest.dto.UsuarioDTO;
import com.zuptest.ZupTest.exception.UsuarioNotFoundException;
import com.zuptest.ZupTest.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
        return usuarioService.createUsuario(usuarioDTO);
    }

    @GetMapping
    public List<UsuarioDTO> listAll(){
        return usuarioService.listAll();
    }

    @GetMapping("/{id}")
    public UsuarioDTO findById(@PathVariable Long id) throws UsuarioNotFoundException{
        return usuarioService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid UsuarioDTO usuarioDTO)
            throws UsuarioNotFoundException {
        return usuarioService.updateById(id, usuarioDTO);
    }

    @DeleteMapping("/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws UsuarioNotFoundException{
        usuarioService.deleteById(id);
    }

}
