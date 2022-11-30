package com.pds.sgg.index.entity.pessoa.medico;

import com.pds.sgg.index.entity.pessoa.Pessoa;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Medico extends Pessoa {
    @Id
    @SequenceGenerator(
            name = "medico_sequence",
            sequenceName = "medico_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "medico_sequence"
    )    
    private Long id;

    private Long IdPessoa;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Especialidade> idsEspecialidades;

    public Medico(){

    }

    public Medico(Long id, Long IdPessoa, Set<Especialidade> idsEspecialidades, Long idUsuario, String nome, String email, String telefone, String endereco) {
        super(IdPessoa, idUsuario,nome,email,telefone, endereco);
        this.id = id;
        this.IdPessoa = IdPessoa;
        this.idsEspecialidades = idsEspecialidades;
    }

    public Long getId() {return id;}
    public Long getIdPessoa() {
        return IdPessoa;
    }
    public Set<Especialidade> getIdsEspecialidades() {
        return idsEspecialidades;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setIdPessoa(Long IdPessoa) {
        this.IdPessoa = IdPessoa;
    }
    public void setIdsEspecialidades(Set<Especialidade> idsEspecialidades) {
        this.idsEspecialidades = idsEspecialidades;
    }

}
