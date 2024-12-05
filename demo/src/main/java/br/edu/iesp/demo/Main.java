package br.edu.iesp.demo;

import br.edu.iesp.demo.controller.ProdutoController;
import br.edu.iesp.demo.model.Produto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProdutoController produtoController = new ProdutoController();

        // Adiciona produtos fixos para teste
        produtoController.createProduto(1, "PlayStation", "Console", 999.90);
        produtoController.createProduto(2, "Xbox", "Console", 999.90);
        produtoController.createProduto(3, "Camisa", "Vestuário", 39.90);
<<<<<<< HEAD
        produtoController.createProduto(4, "Notebook", "Eletrônicos", 2500.00);
        produtoController.createProduto(5, "Tênis", "Calçados", 149.90);
        produtoController.createProduto(6, "Smartphone", "Eletrônicos", 1999.90);

        Usuario usuario = new Usuario(produtoController.getProdutos().get(0));
=======
>>>>>>> main

        //Terminal para testes
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Criar Produto");
            System.out.println("2 - Atualizar Preço");
            System.out.println("3 - Remover Produto");
            System.out.println("4 - Listar Produtos");
            System.out.println("5 - Sair");
            System.out.print(": ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar Scanner


            // Lógica para as opções
            switch (opcao) {
                case 1: // Criar um novo produto
                    System.out.print("Digite o ID do produto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Limpar Scanner
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a categoria do produto: ");
                    String categoria = scanner.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();  // Limpar Scanner
                    Produto novoProduto = produtoController.createProduto(id, nome, categoria, preco);
                    System.out.println("Produto criado: " + novoProduto);
                    break;

                case 2: // Atualizar o preço de um produto
                    System.out.print("Digite o ID do produto a ser atualizado: ");
                    int idAtualizar = scanner.nextInt();
                    System.out.print("Digite o novo preço: ");
<<<<<<< HEAD
                    double precoNovo = scanner.nextDouble();
                    produtoController.atualizarPreco(idAtualizar, precoNovo);
=======
                    double novoPreco = scanner.nextDouble();
                    scanner.nextLine();  // Limmpar Scanner
                    Produto produtoAtualizado = produtoController.atualizarPreco(idAtualizar, novoPreco);
                    if (produtoAtualizado != null) {
                        System.out.println("Preço atualizado: " + produtoAtualizado);
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
>>>>>>> main
                    break;

                case 3: // Remover um produto pelo ID
                    System.out.print("Digite o ID do produto a ser removido: ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();  // Limpar Scanner
                    boolean removido = produtoController.removerProduto(idRemover);
                    if (removido) {
                        System.out.println("Produto removido.");
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;

                case 4: // Lista todos os produtos
                    System.out.println("Lista de produtos:");
                    for (Produto p : produtoController.getProdutos()) {
                        System.out.println(p);
                    }
                    break;

                case 5: // Fechar o programa
                    System.out.println("Fechando o programa ...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
