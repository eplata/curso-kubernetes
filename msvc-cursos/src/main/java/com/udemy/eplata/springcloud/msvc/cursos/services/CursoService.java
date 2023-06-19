package com.udemy.eplata.springcloud.msvc.cursos.services;

import java.util.List;
import java.util.Optional;

import com.udemy.eplata.springcloud.msvc.cursos.models.Usuario;
import com.udemy.eplata.springcloud.msvc.cursos.models.entity.Curso;

public interface CursoService {
    public List<Curso> listar();
    public Optional<Curso> porId(Long id);
    public Curso guardar(Curso curso);
    public void eliminar(Long id);
    
    public Optional<Usuario> asignarUsuario(Usuario usuario, Long cursoId);
    public Optional<Usuario> crearUsuario(Usuario usuario, Long cursoId);
    public Optional<Usuario> eliminarUsuario(Usuario usuario, Long cursoId);

}
