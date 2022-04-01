package com.pacoteck.springboot.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pacoteck.springboot.app.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

	
	public abstract List<Curso> findByProfesor(Long Profesor);
}
