package com.microsservico.estoque_padaria.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estoque")
public class Estoque {

    @Id
    @Column(name = "id_produto", length = 10, nullable = false)
    private int idProduto;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "valor_unitario", length = 12, nullable = false)
    private double valorUnitario;

    @Column(name = "quantidade", length = 10, nullable = false)
    private int quantidade;

    @Column(name = "descricao", length = 200, nullable = false)
    private String descricao;

    @Column(name = "categoria", length = 20, nullable = false)
    private String categoria;

    public int getIdProduto() {
        return idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
