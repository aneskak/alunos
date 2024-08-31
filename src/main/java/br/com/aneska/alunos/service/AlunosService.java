package br.com.aneska.alunos.service;

import br.com.aneska.alunos.model.Aluno;
import br.com.aneska.alunos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AlunosService {
    @Autowired
    private AlunoRepository alunoRepository;

    public Optional<Aluno> atualizar(Aluno aluno){
        if(alunoRepository.findById(aluno.getId()).isPresent()) {

            Optional<Aluno> buscaAluno = alunoRepository.findById(aluno.getId());
            if((buscaAluno.isPresent()) && (buscaAluno.get().getId() != aluno.getId())){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aluno não existe.", null);
            }

            aluno.setId(aluno.getId());
            aluno.setIdade(aluno.getIdade());
            aluno.setNome(aluno.getNome());
            aluno.setNomeProfessor(aluno.getNomeProfessor());
            aluno.setNumeroSala(aluno.getNumeroSala());
            aluno.setNotaPrimeiroSemestre(aluno.getNotaPrimeiroSemestre());
            aluno.setNotaSegundoSemestre(aluno.getNotaSegundoSemestre());

            return Optional.ofNullable(alunoRepository.save(aluno));
        }
        return Optional.empty();
    }

}
