package br.edu.iesp.demo;

import br.edu.iesp.demo.controller.ProdutoController;
import br.edu.iesp.demo.model.Produto;
import br.edu.iesp.demo.model.Usuario;

import java.util.ArrayList;
import java.util.List;
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

        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario2 = new Usuario("teste", usuarios.size());
        usuarios.add(usuario2);

        while (true) {
            // Menu de opções
            System.out.println("\n======= MENU PRINCIPAL =======");
            System.out.println("1  - Listar produtos");
            System.out.println("2  - Criar produto");
            System.out.println("3  - Remover produto");
            System.out.println("4  - Atualizar preço");
            System.out.println("5  - Listar meus produtos");
            System.out.println("6  - Adicionar produto ao usuário");
            System.out.println("7  - Remover produto do usuário");
            System.out.println("8  - Listar usuários na publisher");
            System.out.println("9  - Inscrever usuário na publisher");
            System.out.println("10 - Desinscrever usuário da publisher");
            System.out.println("11 - Sair");
            System.out.println("==============================");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            System.out.println(); // Linha em branco para separar as saídas

            switch (opcao) {
                case 1: // Listar produtos
                    System.out.println("===== Produtos Cadastrados =====");
                    for (Produto produto : produtoController.getProdutos()) {
                        System.out.printf("ID: %d | Nome: %s | Categoria: %s | Preço: R$ %.2f%n",
                                produto.getId(), produto.getNome(), produto.getCategoria(), produto.getPreco());
                    }
                    System.out.println("===============================");
                    break;

                case 2: // Criar produto
                    System.out.print("Digite o ID do produto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir a linha pendente
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a categoria do produto: ");
                    String categoria = scanner.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();
                    produtoController.createProduto(id, nome, categoria, preco);
                    System.out.println("Produto criado com sucesso!");
                    break;

                case 3: // Remover produto
                    System.out.print("Digite o ID do produto a ser removido: ");
                    int idRemover = scanner.nextInt();
                    if (produtoController.removerProduto(idRemover)) {
                        System.out.println("Produto removido com sucesso!");
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
                    System.out.println("Preço atualizado com sucesso!");
                    break;

                case 5: // Listar meus produtos
                    System.out.println("===== Produtos do Usuário =====");
                    usuarios.get(0).listProdutos();
                    System.out.println("===============================");
                    break;

                case 6: // Adicionar produto ao usuário
                    System.out.print("Digite o ID do produto para adicionar: ");
                    int idAdicionar = scanner.nextInt();
                    System.out.print("Digite o preço que deseja: ");
                    double precoAdicionar = scanner.nextDouble();
                    if (produtoController.getProdutos().get(0) != null) {
                        System.out.println("Produto válido.");
                    }
                    usuarios.get(0).addProduto(new Produto(idAdicionar, produtoController.getProdutos().get((idAdicionar - 1)).getNome(),
                            produtoController.getProdutos().get((idAdicionar - 1)).getCategoria(), precoAdicionar));
                    System.out.println("Produto adicionado ao usuário.");
                    break;

                case 7: // Remover produto do usuário
                    System.out.print("Digite o ID do produto para remover do usuário: ");
                    int idRemoverUsuario = scanner.nextInt();
                    for (Usuario usuario : usuarios) {
                        usuario.removeProduto(new Produto(idRemoverUsuario, "teste", "teste", 0));
                    }
                    System.out.println("Produto removido do usuário.");
                    break;

                case 8: // Listar usuários na publisher
                    System.out.println("===== Usuários Inscritos =====");
                    produtoController.listSubscribers();
                    System.out.println("==============================");
                    break;

                case 9: // Inscrever usuário na publisher
                    produtoController.addObserverToProduto(/*idInscrever*/ 1, usuario2);
                    System.out.println("Usuário inscrito como observador do produto.");
                    break;

                case 10: // Desinscrever usuário da publisher
                    produtoController.removeObserverFromProduto(/*idDesinscrever*/ 1, usuarios.get(0));
                    System.out.println("Usuário desinscrito do produto.");
                    break;

                case 11: // Sair
                    System.out.println("Saindo... Até logo!");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
