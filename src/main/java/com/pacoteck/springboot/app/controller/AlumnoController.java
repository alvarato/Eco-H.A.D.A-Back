package com.pacoteck.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pacoteck.springboot.app.entity.Alumno;
import com.pacoteck.springboot.app.service.AlumnoService;

@RestController
@RequestMapping(value = "/alumno")
public class AlumnoController {
	
	@Autowired
	public AlumnoService as;
	
	@PostMapping()
	public String create(@RequestBody Alumno alumno) {
		try {
			as.create(alumno);
			return "Alumno creado";
		} catch (Exception e) {
			// TODO: handle exception
			return "Error al crear alumno";
		}

	}
	
	@GetMapping(path = "/delete{id}")
	public String delete(@PathVariable("id") Long id) {
		try {
			as.deleteByid(id);
			return "Alumno eliminado";
		} catch (Exception e) {
			return "Error al eliminar el alumno";
		}

	}
	
	@GetMapping(path = "/find{id}")
	public Alumno listarAlumnos(@PathVariable("id") Long id){
		return as.porId(id);
	}
	
	@PostMapping(value="/asignarInsignea")
	public String asignarInsignea(@RequestParam Long insignea,@RequestParam Long alumno) {
		  
		  try {
			  as.asignarInsignea(insignea, alumno);
			  return "Insignea Asignada";
		} catch (Exception e) {
			// TODO: handle exception
			return "Error al asignar la insignea";
		}
		
	}
	
	@PostMapping(value="/asignarTarea")
	public String asignarTarea(@RequestParam Long tarea,@RequestParam Long alumno) {
		  
		  try {
			  as.asignarTarea(tarea, alumno);
			  return "Tarea Asignada";
		} catch (Exception e) {
			// TODO: handle exception
			return "Error al asignar la Tarea";
		}
		
	}
	
	
	@PostMapping(value = "/iniciarSesion")
	public Long iniciarSesion(@RequestParam String email, @RequestParam String password) {
		Long id = as.validar(email, password);
		if( id > 0) {
			return id;
			
		}else {
			return (long) 0;
			 
		}
		
	}
	
	
}
