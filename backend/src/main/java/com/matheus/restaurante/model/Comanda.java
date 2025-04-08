
package com.matheus.restaurante.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comanda {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Usuario cliente;

    private LocalDateTime dataHora = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Status status = Status.ABERTA;

    public enum Status {
        ABERTA, EM_PREPARO, ENTREGUE, CANCELADA
    }

    // Getters e Setters
}
