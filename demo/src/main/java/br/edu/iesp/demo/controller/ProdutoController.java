package br.edu.iesp.demo.controller;

import br.edu.iesp.demo.model.Produto;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProdutoController {
    // Simula um banco de dados
    private List<Produto> produtos;

    public ProdutoController() {
        produtos = new ArrayList<>();
    }

    // Método para criar um novo produto
    public Produto createProduto(int id, String nome, String categoria, double preco) {
        Produto produto = new Produto(id, nome, categoria, preco);
        produtos.add(produto);
        return produto;
    }

    // Método para atualizar o preço de um produto, utiliza o ID para a busca
    public Produto atualizarPreco(int id, double precoNovo) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.setPreco(precoNovo);
                return produto;
            }
        }
        return null;
    }

    // Método para remover um produto, utiliza o ID para a busca
    public boolean removerProduto(int id) {
        return produtos.removeIf(produto -> produto.getId() == id);
    }
}
