package com.pacoteck.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pacoteck.springboot.app.entity.Insignea;
import com.pacoteck.springboot.app.service.InsigneaService;

@RestController
@RequestMapping(value = "/insignia")
public class InsigneaController {

	@Autowired
	public InsigneaService is;
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping(value = "/findall")
	public List<Insignea> findall(){
		return is.findall();
	}
}
