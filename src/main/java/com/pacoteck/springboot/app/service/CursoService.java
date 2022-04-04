package com.pacoteck.springboot.app.service;


import java.util.List;
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
	
	public String asignar(List<Alumno> alumnos, Long curso) {
		List<Curso> cursos = cr.findAll();
		Curso cursoAux = null;
		List<Alumno> alumnosAux = null;
		try {
			for (Curso curso2 : cursos) {
				cursoAux = curso2;
				alumnosAux = cursoAux.getAlumnos();
				cr.save(cursoAux);
				if(curso2.getId() == curso) {
					for (Alumno alumno : alumnos) {
						alumnosAux.add(alumno);
					}
					cursoAux.setAlumnos(alumnosAux);
					
				}
			}

			return "Alumnos asignados";
		} catch (Exception e) {
			// TODO: handle exception
			return "Error al Asignar alumnos";
		}
	}







}
