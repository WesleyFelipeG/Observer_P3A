package br.edu.iesp.demo.controller;

import br.edu.iesp.demo.model.ISubscriber;
import br.edu.iesp.demo.model.Produto;
import br.edu.iesp.demo.model.Publisher;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

@Getter
public class ProdutoController {

    private final List<Produto> produtos;
    private Publisher publisher = new Publisher();

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
                publisher.update(produto);
                return produto;
            }
        }
        return null;
    }

    // Método para remover um produto, utiliza o ID para a busca
    public boolean removerProduto(int id) {
        return produtos.removeIf(produto -> produto.getId() == id);
    }

    // Método para adicionar um observador
    public void addObserverToProduto(int id, ISubscriber observer) {
        publisher.subscribe(observer);
    }

    // Método para remover um observador
    public void removeObserverFromProduto(int id, ISubscriber observer) {
        publisher.unsubscribe(observer);
    }
}
