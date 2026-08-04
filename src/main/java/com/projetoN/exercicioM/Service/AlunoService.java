package com.projetoN.exercicioM.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoN.exercicioM.Entity.Aluno;
import com.projetoN.exercicioM.Repository.AlunoRepository;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository; 

    public AlunoService(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> listarTodos(){
        return alunoRepository.findAll();
    }

    public Aluno salvarAluno(Aluno aluno){
        return alunoRepository.save(aluno);

    }
    
    public Aluno BuscaralunoPorId(Long id) {
        return alunoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado com o ID: " + id));
    }

    
    public Aluno Alterar(Long id, Aluno oaluno){
       Aluno alunoExistente = BuscaralunoPorId(id);

       alunoExistente.setNome(oaluno.getNome());
       alunoExistente.setEmail(oaluno.getEmail());
       alunoExistente.setCpf(oaluno.getCpf());
       
       return alunoRepository.save(alunoExistente);
    }

    public void deletaAluno(Long id){
        Aluno alunoExistente = BuscaralunoPorId(id);
        alunoRepository.delete(alunoExistente);
    }


}




