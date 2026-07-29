package com.projetoN.exercicioM.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "Curso")
@NoArgsConstructor
@Data
public class Curso {
@Id    
@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
private long idcurso;

}
