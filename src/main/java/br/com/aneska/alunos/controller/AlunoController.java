package br.com.aneska.alunos.controller;

import br.com.aneska.alunos.model.Aluno;
import br.com.aneska.alunos.repository.AlunoRepository;
import br.com.aneska.alunos.service.AlunosService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunosService alunosService;

    @Operation(description = "Cadastra alunos")
    @PostMapping("/cadastrar")
    public ResponseEntity<Aluno> cadastrarAluno(@Valid @RequestBody Aluno aluno)
    {
        return ResponseEntity.ok(alunoRepository.save(aluno));
    }

    @Operation(description = "Busca todos os alunos cadastrados.")
    @GetMapping("/listartodos")
    public ResponseEntity<Iterable<Aluno>> listarTodos(){
        return ResponseEntity.ok(alunoRepository.findAll());
    }


    @Operation(description = "Busca alunos por id.")
    @GetMapping("listar/{id}")
    public ResponseEntity<Aluno> listarAlunoById(@PathVariable Long id) {
        return alunoRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(description = "Atualiza dados do aluno por id.")
    @PutMapping("atualizar/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        return alunosService.atualizar(aluno)
                .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(description = "Deleta aluno por id.")
    @DeleteMapping("deletar/{id}")
    public void deleteByID(@PathVariable long id) {
        alunoRepository.deleteById(id);
    }





}
