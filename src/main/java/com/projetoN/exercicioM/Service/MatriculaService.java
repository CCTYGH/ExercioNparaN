package com.projetoN.exercicioM.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetoN.exercicioM.Entity.Matricula;
import com.projetoN.exercicioM.Repository.MatriculaRepository;

@Service
public class MatriculaService {
    
private final MatriculaRepository matriculaRepository;
private final AlunoService alunoService;
private final CursoService cursoService;


public MatriculaService(MatriculaRepository matriculaRepository,
    AlunoService alunoService,
    CursoService cursoService
) {
    this.matriculaRepository = matriculaRepository;
    this.alunoService = alunoService;
    this.cursoService = cursoService;
}

public List<Matricula> listarMatricula(){
    return matriculaRepository.findAll();
}


public Matricula salvarMatricula(Matricula matricula){
    return matriculaRepository.save(matricula);
}

}
