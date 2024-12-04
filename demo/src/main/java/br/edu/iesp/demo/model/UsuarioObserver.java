package br.edu.iesp.demo.model;

public class UsuarioObserver implements Observer {
    private final String nome;

    public UsuarioObserver(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(Produto produto) {
        System.out.println("Olá, " + nome + "! O preço do produto " + produto.getNome() + " mudou para R$" + produto.getPreco());
    }
}
