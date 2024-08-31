package br.com.aneska.alunos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ALUNO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer idade;

    private Integer notaPrimeiroSemestre;

    private Integer notaSegundoSemestre;

    private String nomeProfessor;

    private Integer numeroSala;

}

