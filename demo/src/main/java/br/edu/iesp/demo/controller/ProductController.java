package br.edu.iesp.demo.controller;

import br.edu.iesp.demo.model.Product;
import br.edu.iesp.demo.service.ProductService;

import java.util.List;

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public Product createProduct(int id, String name, String category, double price) {
        return productService.createProduct(id, name, category, price);
    }

    public Product updatePrice(int id, double newPrice) {
        return productService.updatePrice(id, newPrice);
    }

    public boolean removeProduct(int id) {
        return productService.removeProduct(id);
    }

    public List<Product> listProducts() {
        return productService.listProducts();
    }
}
