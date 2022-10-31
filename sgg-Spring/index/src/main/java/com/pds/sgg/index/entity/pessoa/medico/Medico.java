package com.pds.sgg.index.entity.pessoa.medico;

import com.pds.sgg.index.entity.pessoa.Pessoa;
import java.util.List;

public class Medico extends Pessoa {
    private Long idMedico;
    private Long IdPessoa;
    private List<Long> idsEspecialidades;

    public Medico(Long idMedico, Long IdPessoa, List<Long> idsEspecialidades, Long idUsuario, String nome, String email, String telefone, String endereco) {
        super(IdPessoa, idUsuario,nome,email,telefone, endereco);
        this.idMedico = idMedico;
        this.IdPessoa = IdPessoa;
        this.idsEspecialidades = idsEspecialidades;
    }

    public Long getIdMedico() {return idMedico;}
    public Long getIdPessoa() {
        return IdPessoa;
    }
    public List<Long> getIdsEspecialidades() {
        return idsEspecialidades;
    }
    public void setId(Long idMedico) {
        this.idMedico = idMedico;
    }
    public void setIdPessoa(Long IdPessoa) {
        this.IdPessoa = IdPessoa;
    }
    public void setIdsEspecialidades(List<Long> idsEspecialidades) {
        this.idsEspecialidades = idsEspecialidades;
    }

}
