package com.zuptest.ZupTest.mapper;

import com.zuptest.ZupTest.dto.UsuarioDTO;
import com.zuptest.ZupTest.entity.Usuario;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-30T19:36:02-0400",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.10 (JetBrains s.r.o.)"
)
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toModel(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setDataNascimento( usuarioDTO.getDataNascimento() );
        usuario.setId( usuarioDTO.getId() );
        usuario.setName( usuarioDTO.getName() );
        usuario.setCpf( usuarioDTO.getCpf() );
        usuario.setEmail( usuarioDTO.getEmail() );

        return usuario;
    }

    @Override
    public UsuarioDTO toDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId( usuario.getId() );
        usuarioDTO.setName( usuario.getName() );
        usuarioDTO.setCpf( usuario.getCpf() );
        usuarioDTO.setEmail( usuario.getEmail() );
        usuarioDTO.setDataNascimento( usuario.getDataNascimento() );

        return usuarioDTO;
    }
}
