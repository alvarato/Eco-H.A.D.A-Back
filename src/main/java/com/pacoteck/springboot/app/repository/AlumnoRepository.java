package com.pacoteck.springboot.app.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pacoteck.springboot.app.entity.Alumno;



@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{
		
	public abstract List<Alumno> findByCurso(Long id);
}
