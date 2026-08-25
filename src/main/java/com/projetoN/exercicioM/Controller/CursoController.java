package com.projetoN.exercicioM.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetoN.exercicioM.Entity.Curso;

import com.projetoN.exercicioM.Service.CursoService;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/curso")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService){
        this.cursoService = cursoService;
    }

    @GetMapping("/listarCurso")
    public String listarCurso(Model  oModel) {
        oModel.addAttribute("listCurso", cursoService.listarCurso());
        return "curso/listarCurso";
    }
    
    @GetMapping("/cadastrarCurso")
    public String cadastrarCurso( Model oModel) {
        oModel.addAttribute("curso", new Curso());
        return "/curso/cadastrarCurso";
    }
    
@PostMapping("/salvar")
public String salvar(Curso curso, Model oModel ) {
   
    cursoService.salvar(curso);
    return "redirect:/curso/listarCurso";
}

@GetMapping("/excluir/{id}")
public String excluirCurso(@PathVariable Long id) {

    cursoService.deletarCurso(id);
    return "redirect:/curso/listarCurso";
}




}
