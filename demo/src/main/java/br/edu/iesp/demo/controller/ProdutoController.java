package br.edu.iesp.demo.controller;

import br.edu.iesp.demo.model.Observer;
import br.edu.iesp.demo.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    private final List<Produto> produtos;

    public ProdutoController() {
        produtos = new ArrayList<>();
    }

    // Método para listar os produtos
    public List<Produto> getProdutos() {
        return produtos;
    }

    // Método para criar produto
    public void createProduto(int id, String nome, String categoria, double preco) {
        Produto produto = new Produto(id, nome, categoria, preco);
        produtos.add(produto);
    }

    // Método para atualizar preço
    public Produto atualizarPreco(int id, double precoNovo) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.setPreco(precoNovo);
                return produto;
            }
        }
        return null;
    }

    // Método para remover produto
    public boolean removerProduto(int id) {
        return produtos.removeIf(produto -> produto.getId() == id);
    }

    // Método para adicionar um observador
    public void addObserverToProduto(int id, Observer observer) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.addObserver(observer);
                return;
            }
        }
        System.out.println("Produto com ID " + id + " não encontrado.");
    }

    // Método para remover um observador
    public void removeObserverFromProduto(int id, Observer observer) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.removeObserver(observer);
                return;
            }
        }
        System.out.println("Produto com ID " + id + " não encontrado.");
    }
}
