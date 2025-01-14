package br.edu.iesp.demo.service;

import br.edu.iesp.demo.model.Product;
import br.edu.iesp.demo.model.Publisher;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private final List<Product> products = new ArrayList<>();
    private final Publisher publisher;

    public ProductService(Publisher publisher) {
        this.publisher = publisher;
    }

    public Product createProduct(int id, String name, String category, double price) {
        Product product = new Product(id, name, category, price);
        products.add(product);
        return product;
    }

    public Product updatePrice(int id, double newPrice) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setPrice(newPrice);
                publisher.notifySubscribers(product);
                return product;
            }
        }
        return null;
    }

    public boolean removeProduct(int id) {
        return products.removeIf(product -> product.getId() == id);
    }

    public List<Product> listProducts() {
        return products;
    }
}