package br.edu.famper.api_projetos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "projeto")
@Data
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projeto_id")
    private Long id;

    @Column(name = "nome", nullable = true)
    private String nome;

    @Column(name = "description", nullable = true)
    private String descricao;

    @Column(name = "data_inicio", nullable = true)
    private Date dataInicio;

    @Column(name = "data_fim", nullable = true)
    private Date dataFim;

}
