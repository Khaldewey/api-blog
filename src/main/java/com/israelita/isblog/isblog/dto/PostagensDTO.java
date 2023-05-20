package com.israelita.isblog.isblog.dto;

import com.israelita.isblog.isblog.entities.Postagens;
import org.springframework.beans.BeanUtils;

public class PostagensDTO {

    private Long id;
    private String titulo;
    private String foto;
    private String descricao;

    public PostagensDTO( Postagens entity){
        BeanUtils.copyProperties(entity,this);
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
}
