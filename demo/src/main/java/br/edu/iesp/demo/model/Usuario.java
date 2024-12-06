package br.edu.iesp.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario implements ISubscriber {

    private String nome;
    private int id;
    private List<Produto> produtos;

    public Usuario(String nome, int id) {
        this.nome = nome;
        this.id = id;
        this.produtos = new ArrayList<>();
    }

    public void addProduto(Produto produto) {
        produtos.add(produto);
        System.out.printf("Produto '%s' (ID: %d) adicionado ao usuário '%s'.%n",
                produto.getNome(), produto.getId(), nome);
    }

    public void removeProduto(Produto produto) {
        if (produtos.remove(produto)) {
            System.out.printf("Produto '%s' (ID: %d) removido do usuário '%s'.%n",
                    produto.getNome(), produto.getId(), nome);
        } else {
            System.out.printf("Produto '%s' (ID: %d) não encontrado para o usuário '%s'.%n",
                    produto.getNome(), produto.getId(), nome);
        }
    }

    public void listProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado para o usuário.");
        } else {
            System.out.println("===== Produtos do Usuário =====");
            for (Produto produto : produtos) {
                System.out.printf("ID: %d | Nome: %s | Categoria: %s | Preço: R$ %.2f%n",
                        produto.getId(), produto.getNome(), produto.getCategoria(), produto.getPreco());
            }
            System.out.println("===============================");
        }
    }

    @Override
    public void update(Produto produto) {
        for (Produto myProduto : produtos) {
            if (produto.getId() == myProduto.getId()) {
                if (produto.getPreco() < myProduto.getPreco()) {
                    System.out.printf("Atenção! O preço do produto '%s' (ID: %d) mudou para R$ %.2f.%n",
                            produto.getNome(), produto.getId(), produto.getPreco());
                }
            }
        }
    }
}
