package br.edu.iesp.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    private int id;
    private String nome;
    private String categoria;
    private double preco;

    private List<Observer> observers = new ArrayList<>();

    public Produto(int id, String nome, String categoria, double preco) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.observers = new ArrayList<>();
    }

    // Método para adicionar um observador
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Método para remover um observador
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Método para alterar o preço e notificar os observadores
    public void setPreco(double preco) {
        this.preco = preco;
        // Notifica os observadores diretamente dentro do setter
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
