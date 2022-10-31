package com.pds.sgg.index.entity.pessoa;

import javax.persistence.*;

@Entity
@Table
public class Pessoa {
    @Id
    @SequenceGenerator(
        name = "pessoa_sequence",
        sequenceName = "pessoa_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "pessoa_sequence"
    )
    private Long id;
    private Long idUsuario;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;

    public Pessoa(Long id, Long idUsuario, String nome, String email, String telefone, String endereco) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    public Long getId() {
        return id;
    }
    public Long getIdUsuario() {
        return idUsuario;
    }
    public String getNome() {
        return  nome;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}