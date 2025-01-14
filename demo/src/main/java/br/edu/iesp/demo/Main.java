package br.edu.iesp.demo;

import br.edu.iesp.demo.controller.ProductController;
import br.edu.iesp.demo.model.Publisher;
import br.edu.iesp.demo.model.Product;
import br.edu.iesp.demo.model.User;
import br.edu.iesp.demo.service.ProductService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Publisher publisher = new Publisher();
        ProductService productService = new ProductService(publisher);
        ProductController productController = new ProductController(productService);

        productController.createProduct(1, "PlayStation", "Console", 999.90);
        productController.createProduct(2, "Xbox", "Console", 999.90);
        productController.createProduct(3, "Shirt", "Clothing", 39.90);

        User user = new User(productController.listProducts().get(0));
        publisher.subscribe(user);

        // Terminal for testing
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1 - Create Product");
            System.out.println("2 - Update Price");
            System.out.println("3 - Remove Product");
            System.out.println("4 - List Products");
            System.out.println("5 - Exit");
            System.out.print(": ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Clear Scanner

            switch (option) {
                case 1: // Create a new product
                    System.out.print("Enter the product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Clear Scanner
                    System.out.print("Enter the product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the product category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter the product price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();  // Clear Scanner
                    Product newProduct = productController.createProduct(id, name, category, price);
                    System.out.println("Product created: " + newProduct);
                    break;

                case 2: // Update the price of a product
                    System.out.print("Enter the product ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    System.out.print("Enter the new price: ");
                    double newPrice = scanner.nextDouble();
                    productController.updatePrice(idToUpdate, newPrice);
                    break;

                case 3: // Remove a product by ID
                    System.out.print("Enter the product ID to remove: ");
                    int idToRemove = scanner.nextInt();
                    scanner.nextLine();  // Clear Scanner
                    boolean removed = productController.removeProduct(idToRemove);
                    if (removed) {
                        System.out.println("Product removed.");
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;

                case 4: // List all products
                    System.out.println("Product list:");
                    for (Product p : productController.listProducts()) {
                        System.out.println(p);
                    }
                    break;

                case 5: // Close the program
                    System.out.println("Closing the program ...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
