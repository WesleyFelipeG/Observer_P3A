package br.edu.iesp.demo.model;

public class Usuario implements ISubscriber {

    private Produto myProduto;

    public Usuario(Produto produto) {
        this.myProduto = produto;
    }

    @Override
    public void update(Produto produto) {
        System.out.println("teste");
        if (produto.getId() == myProduto.getId()) {
            System.out.println("O preço do produto " + produto.getNome() + " mudou para R$" + produto.getPreco());
        }
    }
}
