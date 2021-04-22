package com.vitorduarte.OrangeTalentsAPI.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Usuario {

    public Usuario() {
    }

    public Usuario(long id, @NotEmpty String nome, @Email String email, @CPF String cpf, @NotNull LocalDate dataNascimento, List<Address> addresses) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.addresses = addresses;
    }

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long id;

    @NotEmpty
    private String nome;

    @Email
    @Column(unique = true)
    private String email;

    @CPF
    @Column(unique = true)
    private String cpf;

    @NotNull
    private LocalDate dataNascimento;

    @LazyCollection(LazyCollectionOption.FALSE)
    @Fetch(FetchMode.JOIN)
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;

    public static final Usuario of(Long userId) {
        Usuario usuario = new Usuario();
        usuario.setId(userId);

        return usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Address> getAddresses() {
        return addresses;
    }
}
