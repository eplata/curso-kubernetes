package com.udemy.eplata.springcloud.msvc.usuarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.eplata.springcloud.msvc.usuarios.models.entities.Usuario;
import com.udemy.eplata.springcloud.msvc.usuarios.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	@Transactional( readOnly = true)
	public List<Usuario> listar() {
		return (List<Usuario>)usuarioRepository.findAll();
	}

	@Override
	@Transactional( readOnly = true)
	public Optional<Usuario> porId(Long id) {
		return usuarioRepository.findById(id);
	}

	@Override
	@Transactional
	public Usuario guardar(Usuario usuario) {
		return  usuarioRepository.save(usuario);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		usuarioRepository.deleteById(id);

	}

	@Override
	public Optional<Usuario> porEmail(String email) {
		return usuarioRepository.porEmail(email);
	}

	@Override
	public boolean existePorEmail(String email) {
		return usuarioRepository.existsByEmail(email);
	}
	
	
	

}
