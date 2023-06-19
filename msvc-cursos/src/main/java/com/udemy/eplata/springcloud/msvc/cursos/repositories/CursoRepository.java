package com.udemy.eplata.springcloud.msvc.cursos.repositories;

import org.springframework.data.repository.CrudRepository;

import com.udemy.eplata.springcloud.msvc.cursos.models.entity.Curso;

public interface CursoRepository extends CrudRepository<Curso, Long> {
}

