package com.projetoN.exercicioM.Service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.projetoN.exercicioM.Entity.Curso;
import com.projetoN.exercicioM.Repository.CursoRepository;

@Service
public class CursoService {

    private final CursoRepository cursoRepository; 

    public CursoService(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> listarCurso(){
        return cursoRepository.findAll();
    }

    public Curso salvar(Curso curso){
        return cursoRepository.save(curso);

    }
    
    public Curso buscaId(Long id) {
        return cursoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Curso não encontrado com o ID: " + id));
    }

    
    public Curso editar(Long id, Curso oCurso){
        Curso cursoExistente = buscaId(id);

        cursoExistente.setNomeCurso(oCurso.getNomeCurso());
        cursoExistente.setDescricao(oCurso.getDescricao());
        cursoExistente.setCargaHora(oCurso.getCargaHora());
       
       return cursoRepository.save(cursoExistente);
    }

    public void deletarCurso(Long id){
        Curso cursoExistente = buscaId(id);
        cursoRepository.delete(cursoExistente);
    }


}




