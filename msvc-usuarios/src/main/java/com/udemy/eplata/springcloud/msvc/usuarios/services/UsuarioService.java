package com.udemy.eplata.springcloud.msvc.usuarios.services;

import java.util.List;
import java.util.Optional;

import com.udemy.eplata.springcloud.msvc.usuarios.models.entities.Usuario;

public interface UsuarioService {

	public List<Usuario> listar();	
	public Optional<Usuario> porId(Long id);	
	public Usuario guardar(Usuario usuario);
	public void eliminar(Long id);	
	public Optional<Usuario> porEmail(String email);
	public boolean existePorEmail(String email);
	
}
