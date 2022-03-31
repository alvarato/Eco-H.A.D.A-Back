package com.pacoteck.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pacoteck.springboot.app.entity.Profesor;
import com.pacoteck.springboot.app.service.ProfesorService;

@RestController
@RequestMapping(value = "/profesor")
public class ProfesorController {

		@Autowired
		public ProfesorService ps;
		
		@PostMapping(value = "/create")
		public String crear(@RequestBody Profesor profesor) {
			try {
				ps.create(profesor);
				return "Profesor creado";
			} catch (Exception e) {
				return "Error al crear el profesor";
			}
			
		}
		
		@GetMapping(value = "/findall")
		public List<Profesor> find() {
			return ps.findAll();
		}
		
		@PostMapping(value = "/iniciarSesion")
		public Long iniciarSesion(@RequestParam String email, @RequestParam String password) {
			Long id = ps.validar(email, password);
			if( id > 0) {
				return id;
				
			}else {
				return (long) 0;
				 
			}
			
		}
		
		
		
}
