package com.israelita.isblog.isblog.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_posts")
public class Postagens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String foto;
    private String descricao;

    public Postagens(){
    }

    public Postagens(Long id, String titulo, String foto, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.foto = foto;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Postagens postagens)) return false;
        return getId().equals(postagens.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
