package br.edu.iesp.demo;

import br.edu.iesp.demo.controller.ProdutoController;
import br.edu.iesp.demo.model.Produto;
import br.edu.iesp.demo.model.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProdutoController produtoController = new ProdutoController();
        Scanner scanner = new Scanner(System.in);

        produtoController.createProduto(1, "PlayStation", "Console", 999.90);
        produtoController.createProduto(2, "Xbox", "Console", 999.90);
        produtoController.createProduto(3, "Camisa", "Vestuário", 39.90);
        produtoController.createProduto(4, "Notebook", "Eletrônicos", 2500.00);
        produtoController.createProduto(5, "Tênis", "Calçados", 149.90);
        produtoController.createProduto(6, "Smartphone", "Eletrônicos", 1999.90);

        Usuario usuario = new Usuario(produtoController.getProdutos().get(0));

        while (true) {
            // Menu de opções
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Listar produtos");
            System.out.println("2 - Criar produto");
            System.out.println("3 - Remover produto");
            System.out.println("4 - Atualizar preço");
            System.out.println("5 - Inscrever com observer");
            System.out.println("6 - Desinscrever com observer");
            System.out.println("7 - Sair");

            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1: // Listar produtos
                    System.out.println("Produtos cadastrados:");
                    for (Produto produto : produtoController.getProdutos()) {
                        System.out.println("ID: " + produto.getId() + " | Nome: " + produto.getNome() + " | Categoria: " + produto.getCategoria() + " | Preço: R$" + produto.getPreco());
                    }
                    break;

                case 2: // Criar produto
                    System.out.print("Digite o ID do produto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consumir a linha pendente
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a categoria do produto: ");
                    String categoria = scanner.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();
                    produtoController.createProduto(id, nome, categoria, preco);
                    break;

                case 3: // Remover produto
                    System.out.print("Digite o ID do produto a ser removido: ");
                    int idRemover = scanner.nextInt();
                    if (produtoController.removerProduto(idRemover)) {
                        System.out.println("Produto removido com sucesso.");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 4: // Atualizar preço
                    System.out.print("Digite o ID do produto: ");
                    int idAtualizar = scanner.nextInt();
                    System.out.print("Digite o novo preço: ");
                    double precoNovo = scanner.nextDouble();
                    produtoController.atualizarPreco(idAtualizar, precoNovo);
                    break;

                case 5: // Inscrever com observer
                    System.out.print("Digite o ID do produto para inscrever o observer: ");
                    int idInscrever = scanner.nextInt();
                    produtoController.addObserverToProduto(idInscrever, usuario);
                    System.out.println("Usuário inscrito como observador do produto.");
                    break;

                case 6: // Desinscrever com observer
                    System.out.print("Digite o ID do produto para desinscrever o observer: ");
                    int idDesinscrever = scanner.nextInt();
                    produtoController.removeObserverFromProduto(idDesinscrever, usuario);
                    System.out.println("Usuário desinscrito do produto.");
                    break;

                case 7: // Sair
                    System.out.println("Saindo...");
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
