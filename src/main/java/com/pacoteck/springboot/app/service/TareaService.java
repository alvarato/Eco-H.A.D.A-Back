package com.pacoteck.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pacoteck.springboot.app.entity.Tarea;
import com.pacoteck.springboot.app.repository.TareaRepository;

public class TareaService {

	@Autowired
	public TareaRepository tr;
	
	public List<Tarea> tareascurso(){
		return tr.findAll();
	}
	
	
	
}
