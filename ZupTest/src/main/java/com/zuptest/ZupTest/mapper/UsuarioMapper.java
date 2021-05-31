package com.zuptest.ZupTest.mapper;

import com.zuptest.ZupTest.dto.UsuarioDTO;
import com.zuptest.ZupTest.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(source = "dataNascimento", target = "dataNascimento", dateFormat = "dd-mm-yyyy")
    Usuario toModel(UsuarioDTO usuarioDTO);

    UsuarioDTO toDTO(Usuario usuario);

}
