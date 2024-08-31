package br.com.aneska.alunos.repository;

import java.util.UUID;

import br.com.aneska.alunos.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {

}
