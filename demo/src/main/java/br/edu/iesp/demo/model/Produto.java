package br.edu.iesp.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Produto {
    private int id;
    private String nome;
    private String categoria;
    private double preco;

<<<<<<< HEAD
    public Produto(int id, String nome, String categoria, double preco) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }
=======
    //Lombok usado para simplificar a construção das classes
>>>>>>> main
}
