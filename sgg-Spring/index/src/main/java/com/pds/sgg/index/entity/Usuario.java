package com.pds.sgg.index.entity;


import javax.persistence.*;

@Entity
@Table
public class Usuario {
    @Id
    @SequenceGenerator(
        name = "usuario_sequence",
        sequenceName = "usuario_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "usuario_sequence"
    )
    private Integer id;

    private String name;

    private String email;

    public Usuario(){
    }

    public Usuario(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}