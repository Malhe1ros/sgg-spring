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
    private Long id;

    private String name;

    private String email;

    private String password;

    public Usuario(){
    }

    public Usuario(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    
}