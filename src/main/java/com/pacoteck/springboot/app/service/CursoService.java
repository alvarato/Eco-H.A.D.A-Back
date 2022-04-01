package com.pacoteck.springboot.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacoteck.springboot.app.entity.Alumno;
import com.pacoteck.springboot.app.entity.Curso;
import com.pacoteck.springboot.app.repository.AlumnoRepository;
import com.pacoteck.springboot.app.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	public CursoRepository cr;
	@Autowired
	public AlumnoRepository ar;
	
	public void create(Curso curso) {
		cr.save(curso);
	}
	
	public void deleteById(Long curso) {
		cr.deleteById(curso);
	}
	
	public List<Curso> cursosbyProfesor(Long profesor){
		List<Curso> cursos = cr.findByProfesor(profesor);
		for (Curso curso : cursos) {
			curso.setAlumnos(null);
		}
		return cursos;
	}
	
	public List<Alumno> alumnosbyProfesor(Long curso){
		List<Curso> cursos = cr.findAll();
		List<Alumno> alumnos = null;
		for (Curso curso2 : cursos) {
			if(curso2.getId()  == curso) {
				alumnos = curso2.getAlumnos();
				for (Alumno alumno : alumnos) {
					alumno.setInsigneas(null);
					alumno.setTareas(null);
				}
				return alumnos;
			}
		}
		return alumnos;
	}
	
	public void addAlumno(Long alumno, Long curso) {
		List<Curso> cursos = cr.findAll();
		List<Alumno> alumnos = ar.findAll();
		Alumno alumnoAux = null;
		Curso cursoAux = null;
		for (Alumno alumno2 : alumnos) {
			if(alumno2.getId() == alumno) {
				alumnoAux = alumno2;
				break;
			}
			alumnos = null;
		}
		for (Curso curso2 : cursos) {
			if(curso2.getId() == curso) {
				cursoAux = curso2;
				alumnos = curso2.getAlumnos();
				break;
			}
		}
		alumnos.add(alumnoAux);
		cr.save(cursoAux);
	}
	
	public void deleteAlumno(Long alumno, Long curso){
		List<Curso> cursos = cr.findAll();
		List<Alumno> alumnos = ar.findAll();
		Alumno alumnoAux = null;
		Curso cursoAux = null;
		for (Alumno alumno2 : alumnos) {
			if(alumno2.getId() == alumno) {
				alumnoAux = alumno2;
				break;
			}
			alumnos = null;
		}
		for (Curso curso2 : cursos) {
			if(curso2.getId() == curso) {
				cursoAux = curso2;
				alumnos = curso2.getAlumnos();
				break;
			}
		}
		alumnos.remove(alumnoAux);
		cursoAux.setAlumnos(alumnos);
		cr.save(cursoAux);
	}
}
