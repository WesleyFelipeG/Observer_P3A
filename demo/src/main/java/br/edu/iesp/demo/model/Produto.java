package br.edu.iesp.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    private int id;
    private String nome;
    private String categoria;
    private double preco;

    //Lombok usado para simplificar a construção das classes
}
