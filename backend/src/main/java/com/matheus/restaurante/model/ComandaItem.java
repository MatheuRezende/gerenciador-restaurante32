
package com.matheus.restaurante.model;

import jakarta.persistence.*;

@Entity
public class ComandaItem {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Comanda comanda;

    @ManyToOne
    private Prato prato;

    private int quantidade;

    // Getters e Setters
}
