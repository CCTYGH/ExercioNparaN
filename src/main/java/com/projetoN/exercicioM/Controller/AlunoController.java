package com.projetoN.exercicioM.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetoN.exercicioM.Entity.Aluno;
import com.projetoN.exercicioM.Service.AlunoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @GetMapping("/listarAluno")
    public String listarAluno(Model  oModel) {
        oModel.addAttribute("listAlunos", alunoService.listarAluno());
        return "aluno/listarAluno";
    }
    
    @GetMapping("/cadastrarAluno")
    public String cadastrarAluno( Model oModel) {
        oModel.addAttribute("aluno", new Aluno());
        return "/aluno/cadastrarAluno";
    }
    
@PostMapping("/salvar")
public String salvar(Aluno aluno, Model oModel ) {
   
    alunoService.salvar(aluno);
    return "redirect:/aluno/listarAluno";
}

@GetMapping("/excluir/{id}")
public String excluirAluno(@PathVariable Long id) {

    alunoService.deletaAluno(id);
    return "redirect:/aluno/listarAluno";
}




}
