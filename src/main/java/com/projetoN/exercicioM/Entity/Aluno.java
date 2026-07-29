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
@Table (name = "TB_aluno")
@Data
public class Aluno {
    
    @Id
@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
@Column (name = "idaluno", nullable = false, unique = true)
private long idaluno;


@Column(name="nome", nullable = false, length = 100)
private String nome;

@Column (name = "cpf",  nullable =  false, unique = true, length = 40)
private String cpf;

@Column (name = "email",  nullable =  false, unique = true, length = 100)
private String email;
}
