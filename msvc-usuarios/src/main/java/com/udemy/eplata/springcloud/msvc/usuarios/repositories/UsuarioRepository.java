package com.udemy.eplata.springcloud.msvc.usuarios.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.udemy.eplata.springcloud.msvc.usuarios.models.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{


	public Optional<Usuario> findByEmail(String email);
	
	@Query("SELECT u FROM Usuario u WHERE u.email = ?1")
	public Optional<Usuario> porEmail(String email);
		
	public boolean existsByEmail(String email);
}
