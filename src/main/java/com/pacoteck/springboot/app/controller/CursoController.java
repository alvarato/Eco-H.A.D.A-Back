package com.pacoteck.springboot.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pacoteck.springboot.app.entity.Alumno;
import com.pacoteck.springboot.app.entity.Curso;
import com.pacoteck.springboot.app.service.CursoService;

@RestController
@RequestMapping(value = "/curso")
public class CursoController {

	@Autowired
	public CursoService cs;
	
	
	//trae todos los cursos de un profesor
	@GetMapping(path = "/profesor{profesor}")
	public List<Curso> cursosProfesor(@PathVariable("profesor") Long profesor){
		return cs.cursosbyProfesor(profesor);
	}
	
	//crea un curso
	@PostMapping(value = "/create")
	public void create(@RequestBody Curso curso) {
		cs.create(curso);
	}
	
	//trae todos los alumnos de un curso
	@GetMapping(path = "/alumno{curso}")
	public List<Alumno> alumnosCurso(@PathVariable("curso") Long curso) {
		return cs.alumnosbyProfesor(curso);
	}
	
	//asgina un curso a un alumno;
	@PostMapping(value ="/asignar")
	public Stro
	
}
