package com.pacoteck.springboot.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacoteck.springboot.app.entity.Alumno;
import com.pacoteck.springboot.app.entity.Insignea;
import com.pacoteck.springboot.app.entity.Profesor;
import com.pacoteck.springboot.app.entity.Tarea;
import com.pacoteck.springboot.app.repository.AlumnoRepository;
import com.pacoteck.springboot.app.repository.InsigneaRepository;
import com.pacoteck.springboot.app.repository.TareaRepository;

@Service
public class AlumnoService {
	
	@Autowired
	AlumnoRepository ar;
	
	@Autowired
	InsigneaRepository ir;
	
	@Autowired
	TareaRepository tr;
	
	public void create(Alumno alumno) {
		ar.save(alumno);
	}
	
	public void deleteByid(Long id) {
		ar.deleteById(id);
	}
	
	public void update(Alumno alumno) {
		ar.save(alumno);
	}
	
	public List<Alumno> read() {
		return ar.findAll();
	}
	
	public List<Alumno> findAllByCurso(Long curso){
		return ar.findByCurso(curso);
	}
	
	public Alumno porId(Long id) {
		List<Alumno> alumnos = ar.findAll();
		Alumno alumnoAux = null;
		for (Alumno alumno : alumnos) {
			if(alumno.getId() == id) {
				return alumnoAux = alumno;
			}
		}
		return alumnoAux;
	}
	
	public void asignarInsignea(Long insignea, Long id) {
				List<Alumno> a = this.read();
				List<Insignea> i = ir.findAll();
				Alumno alumnoAux = null;
				Insignea in = null;
				// Busca la insignea por id 
				for (Insignea insignea2 : i) {
					if(insignea2.getId() == insignea) {
						in = insignea2;
						break;
					}
				}
				// Busca al alumno por id y se le asigna una insignea
				for (Alumno alumno : a) {
					if(alumno.getId() == id) {
						alumnoAux = alumno;
						List<Insignea> insineasAux = alumnoAux.getInsigneas();
						insineasAux.add(in);
						alumnoAux.setInsigneas(insineasAux);
						break;
					}
				}
					ar.save(alumnoAux);
				
	}
	
	
	public void asignarTarea(Long tarea, Long id) {
		List<Alumno> a = this.read();
		List<Tarea> i = tr.findAll();
		Alumno alumnoAux = null;
		Tarea taAux = null;
		// Busca la tarea por id 
		for (Tarea tarea2 : i) {
			if(tarea2.getId() == tarea) {
				taAux= tarea2;
				break;
			}
		}
		// Busca al alumno por id y se le asigna una Tarea
		for (Alumno alumno : a) {
			if(alumno.getId() == id) {
				alumnoAux = alumno;
				List<Tarea> tareasAux = alumnoAux.getTareas();
				tareasAux.add(taAux);
				alumnoAux.setTareas(tareasAux);
				break;
			}
		}
			ar.save(alumnoAux);
		
		
	}
	
	
	public Long validar(String email, String password) {
		List<Alumno> alumnos = ar.findAll();
		for (Alumno alumno : alumnos) {
			if(email.equals(alumno.getUserName()) && password.equals(alumno.getPassword())) {
				return alumno.getId();
			}
		}
		return (long) 0;
		 
	}
	
}
