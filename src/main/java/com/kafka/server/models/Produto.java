package com.kafka.server.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
    @Column(name = "valor", nullable = false)
    private Integer valor;
    @Column(name = "data")
    private Timestamp dataCadastro;

    public Produto() {
        super();
    }

    public Produto(Integer id, String nome, String descricao, Integer quantidade, Timestamp dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.dataCadastro = dataCadastro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
