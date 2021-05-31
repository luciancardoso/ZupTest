package com.zuptest.ZupTest.repository;

import com.zuptest.ZupTest.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
