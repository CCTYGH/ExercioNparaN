package com.projetoN.exercicioM.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatricula;
    
    
    @ManyToOne
    @JoinColumn(name = "idaluno", nullable = false)
    private Aluno aluno;


    @ManyToOne
    @JoinColumn(name = "idcurso", nullable = false)
    private Curso curso;


    @Column(name = "dataMatricula", nullable = false)
    private String dataMatricula;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "notaFinal")
    private Double notaFinal;



}
