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
    private Double valor;
    @Column(name = "data")
    private Timestamp dataCadastro;

    public Produto() {
        super();
    }
    

    public Produto( String nome, String descricao, Integer quantidade, Double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Integer getQuantidade(){
        return this.quantidade;
    }

    public void setQuantidadee(Integer quantidade){
        this.quantidade = quantidade;
    }

}
