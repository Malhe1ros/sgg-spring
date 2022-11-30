package com.pds.sgg.index.entity.pessoa.medico;

import com.pds.sgg.index.entity.pessoa.medico.Medico;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Especialidade extends Medico {
    @Id
    @SequenceGenerator(
            name = "especialidade_sequence",
            sequenceName = "especialidade_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "especialidade_sequence"
    )
    private Long id;
    private String descricao;

    public Especialidade(){

    }

    public Especialidade(Long id, Long IdPessoa, Set<Especialidade> idsEspecialidades, Long idUsuario, String nome, String email, String telefone, String endereco) {
        super(id, IdPessoa, idsEspecialidades, idUsuario, nome, email, telefone, endereco);
    }

    public Long getId() {
        return id;
    }
    public  String getDescricao() {
        return descricao;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}