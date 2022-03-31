package com.pacoteck.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacoteck.springboot.app.entity.Profesor;
import com.pacoteck.springboot.app.repository.ProfesorRepository;

@Service
public class ProfesorService {

	@Autowired
	public ProfesorRepository pr;
	
	public void create(Profesor profesor) {
		pr.save(profesor);
	}
	
	public List<Profesor> findAll(){
		return pr.findAll();
	}
	
	public Long validar(String email, String password) {
		List<Profesor> profesores = pr.findAll();
		for (Profesor profesor : profesores) {
			if(email.equals(profesor.getEmail()) && password.equals(profesor.getPassword())) {
				return profesor.getId();
			}
		}
		return (long) 0;
		 
	}

	
	
	
	
	
	
	
}
