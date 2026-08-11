package com.projetoN.exercicioM.Entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table (name = "curso")
@Data
public class Curso {
    
    @Id
@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
@Column (name = "idcurso", nullable = false, unique = true)
private long idcurso;


@Column(name="nomeCurso", nullable = false, length = 100)
private String nomeCurso;

@Column (name = "descricao",  nullable =  false, length = 100)
private String descricao;

@Column (name = "cargaHora",  nullable =  false, length = 100)
private Integer cargaHora;
}
