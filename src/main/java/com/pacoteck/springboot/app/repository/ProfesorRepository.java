package com.pacoteck.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pacoteck.springboot.app.entity.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long>{

}
