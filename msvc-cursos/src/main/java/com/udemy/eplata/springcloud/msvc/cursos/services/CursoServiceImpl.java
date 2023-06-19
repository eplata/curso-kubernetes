package com.udemy.eplata.springcloud.msvc.cursos.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.eplata.springcloud.msvc.cursos.clients.UsuarioClientRest;
import com.udemy.eplata.springcloud.msvc.cursos.models.Usuario;
import com.udemy.eplata.springcloud.msvc.cursos.models.entity.Curso;
import com.udemy.eplata.springcloud.msvc.cursos.models.entity.CursoUsuario;
import com.udemy.eplata.springcloud.msvc.cursos.repositories.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService{

    @Autowired
    private CursoRepository repository;
    
    @Autowired
    private UsuarioClientRest client;
    
   
    
    @Override
    @Transactional(readOnly = true)
    public List<Curso> listar() {
        return (List<Curso>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Curso> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Curso guardar(Curso curso) {
        return repository.save(curso);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

	@Override
	@Transactional
	public Optional<Usuario> asignarUsuario(Usuario usuario, Long cursoId) {

		Optional<Curso> o = repository.findById(cursoId);
		
		if( o.isPresent()) {			
			Usuario usuarioMsvc = client.detalle(usuario.getId());
			
			Curso curso = o.get();
			CursoUsuario cursoUsuario = new CursoUsuario();
			cursoUsuario.setUsuarioId(usuarioMsvc.getId());
			
			curso.addCursoUsuario(cursoUsuario);
			repository.save(curso);			
			return Optional.of(usuarioMsvc);			
		}
		
		return Optional.empty();
	}

	@Override
	@Transactional
	public Optional<Usuario> crearUsuario(Usuario usuario, Long cursoId) {
		Optional<Curso> o = repository.findById(cursoId);
		
		if( o.isPresent()) {			
			Usuario usuarioNuevoMsvc = client.crear(usuario);
			
			Curso curso = o.get();
			CursoUsuario cursoUsuario = new CursoUsuario();
			cursoUsuario.setUsuarioId(usuarioNuevoMsvc.getId());
			
			curso.addCursoUsuario(cursoUsuario);
			repository.save(curso);			
			return Optional.of(usuarioNuevoMsvc);			
		}
		
		return Optional.empty();
	}

	@Override
	@Transactional
	public Optional<Usuario> eliminarUsuario(Usuario usuario, Long cursoId) {
		Optional<Curso> o = repository.findById(cursoId);
		
		if( o.isPresent()) {			
			Usuario usuarioMsvc = client.detalle(usuario.getId());
			
			Curso curso = o.get();
			CursoUsuario cursoUsuario = new CursoUsuario();
			cursoUsuario.setUsuarioId(usuarioMsvc.getId());
			
			curso.removeCursoUsuario(cursoUsuario);
			repository.save(curso);			
			return Optional.of(usuarioMsvc);			
		}
		
		return Optional.empty();
	}
}
