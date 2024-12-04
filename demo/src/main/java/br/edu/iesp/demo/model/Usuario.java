package br.edu.iesp.demo.model;

public class Usuario implements Observer {

    @Override
    public void update(Produto produto) {
        System.out.println("O preço do produto " + produto.getNome() + " mudou para R$" + produto.getPreco());
    }
}
