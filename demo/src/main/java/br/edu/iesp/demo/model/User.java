package br.edu.iesp.demo.model;

public class User implements ISubscriber {

    private Product myProduct;

    public User(Product product) {
        this.myProduct = product;
    }

    @Override
    public void update(Product product) {
        if (product.getId() == myProduct.getId()) {
            System.out.println("The price of the product " + product.getName() + " has changed to $" + product.getPrice());
        }
    }
}