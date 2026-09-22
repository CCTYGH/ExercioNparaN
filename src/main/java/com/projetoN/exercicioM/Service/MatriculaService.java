package com.projetoN.exercicioM.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetoN.exercicioM.DTO.MatriculaDto;
import com.projetoN.exercicioM.Entity.Curso;
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


public Matricula salvarMatricula(MatriculaDto matriculaDto){
   Matricula matricula = new Matricula();
   matricula.setIdaluno(alunoService.BuscaralunoPorId(matriculaDto.getIdaluno()));
   matricula.setIdcurso(cursoService.buscaId(matriculaDto.getIdcurso()));

   matricula.setDataMatricula(matriculaDto.getDataMatricula());
   matricula.setNotaFinal(matriculaDto.getNotaFinal());
   matricula.setStatus(matriculaDto.getStatus());

   return matriculaRepository.save(matricula);
}

public  Matricula buscarMatricula(Long id){
    return  matriculaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Curso não encontrado com o ID: " + id));

}

public Matricula editar(Long id, MatriculaDto matriculaDto){

    Matricula matriculaeditar = buscarMatricula(id);

    matriculaeditar.setIdaluno(alunoService.BuscaralunoPorId(matriculaDto.getIdaluno()));
    matriculaeditar.setIdcurso(cursoService.buscaId(matriculaDto.getIdcurso()));

    matriculaeditar.setDataMatricula(matriculaDto.getDataMatricula());
    matriculaeditar.setNotaFinal(matriculaDto.getNotaFinal());
    matriculaeditar.setStatus(matriculaDto.getStatus());


   return matriculaRepository.save(matriculaeditar);
}


    public void deletarMatricula(Long id){
        matriculaRepository.deleteById(id);
    }


}
