package com.projetoN.exercicioM.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoN.exercicioM.Entity.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long>{
    
}






















