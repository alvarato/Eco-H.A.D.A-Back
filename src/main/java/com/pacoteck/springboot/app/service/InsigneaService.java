package com.pacoteck.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacoteck.springboot.app.entity.Insignea;
import com.pacoteck.springboot.app.repository.InsigneaRepository;

@Service
public class InsigneaService {

	
		@Autowired
		public InsigneaRepository ir;
		
		public List<Insignea> findall(){
			return ir.findAll();
		}
}
