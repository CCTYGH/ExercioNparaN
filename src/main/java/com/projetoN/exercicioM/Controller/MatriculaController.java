package com.projetoN.exercicioM.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetoN.exercicioM.DTO.MatriculaDto;
import com.projetoN.exercicioM.Service.AlunoService;
import com.projetoN.exercicioM.Service.CursoService;
import com.projetoN.exercicioM.Service.MatriculaService;
import org.springframework.web.bind.annotation.GetMapping;



@Controller 
@RequestMapping ("/matricula")
public class MatriculaController {


private final MatriculaService matriculaService;
private final CursoService cursoService;
private final AlunoService alunoService;



public MatriculaController(
    
    MatriculaService matriculaService,
    CursoService cursoService,
    AlunoService alunoService
){
    this.matriculaService = matriculaService;
    this.cursoService = cursoService;
    this.alunoService = alunoService;
}

@GetMapping("/listarMatricula")
public String listarMatricula(Model model) {
    model.addAttribute("matricula", matriculaService.listarMatricula());
    return "matricula/listarMatricula";
}

@GetMapping("/cadastrarMatricula")
public String formMatricula(Model model) { /* Essas listas servem para fazer a transferencia dos objetos e facilitar a manutenção */
    model.addAttribute("matriculaDto", new MatriculaDto());
    model.addAttribute("listAlunos", alunoService.listarAluno());
    model.addAttribute("listCurso", cursoService.listarCurso());
    return "matricula/cadastrarMatricula";
}





    
}

  
