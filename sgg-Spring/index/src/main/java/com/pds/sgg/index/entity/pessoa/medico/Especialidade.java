package com.pds.sgg.index.entity.pessoa.medico;

import com.pds.sgg.index.entity.pessoa.medico.Medico;

import java.util.List;

public class Especialidade extends Medico {
    private Long idEspecialidade;
    private String descricao;

    public Especialidade(Long idMedico, Long IdPessoa, List<Long> idsEspecialidades, Long idUsuario, String nome, String email, String telefone, String endereco) {
        super(idMedico, IdPessoa, idsEspecialidades, idUsuario, nome, email, telefone, endereco);
    }

    public Long getIdEspecialidade() {
        return idEspecialidade;
    }
    public  String getDescricao() {
        return descricao;
    }
    public void setIdEspecialidade(Long idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}