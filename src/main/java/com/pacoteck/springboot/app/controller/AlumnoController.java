package com.pacoteck.springboot.app.controller;

import java.util.List;

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
	public List<Alumno> listarAlumnos(@PathVariable("id") Long id){
		return as.findAllByCurso(id);
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
	
}
