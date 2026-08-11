package com.projetoN.exercicioM.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetoN.exercicioM.Entity.Aluno;
import com.projetoN.exercicioM.Entity.Curso;
import com.projetoN.exercicioM.Service.AlunoService;
import com.projetoN.exercicioM.Service.CursoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/curso")
public class CursoController {

    private final CursoService CursoService;

    public CursoController(CursoService CursoService){
        this.CursoService = CursoService;
    }

    @GetMapping("/listarTodos")
    public String listarTodos(Model  oModel) {
        oModel.addAttribute("listCurso", CursoService.listarTodos());
        return "curso/listarCurso";
    }
    
    @GetMapping("/cadastrarCurso")
    public String cadastrarCurso( Model oModel) {
        oModel.addAttribute("curso", new Curso());
        return "curso/cadastrarCurso";
    }
    
@PostMapping("/salvar")
public String salvar(@ModelAttribute("curso") Curso curso ) {
   
    CursoService.salvarCurso(curso);
    return "curso/listarCurso";
}

@GetMapping("/excluir/{id}")
public String excluirCurso(@PathVariable Long id) {

    CursoService.deletarCurso(id);
    return "curso/listarCurso";
}




}
