package com.projetoN.exercicioM.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.projetoN.exercicioM.Entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{
    
}
