package com.fiap.ds.smartmask.repository;

import java.util.Optional;

import com.fiap.ds.smartmask.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
	@Query ("SELECT u FROM Usuario u WHERE u.email = ?1 AND u.senha = ?2")
    Optional<Usuario> findByEmailAndSenha(String email, String senha);
}
