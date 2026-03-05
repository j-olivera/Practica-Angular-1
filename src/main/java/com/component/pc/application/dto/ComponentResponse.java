package com.component.pc.application.dto;

import com.component.pc.domain.enums.Marca;

public class ComponentResponse {
    private Long id;
    private String piece_name;
    private Marca marca;
    private Double price;

    public ComponentResponse(Long id, String piece_name, Marca marca, Double price) {
        this.id = id;
        this.piece_name = piece_name;
        this.marca = marca;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getPiece_name() {
        return piece_name;
    }

    public Marca getMarca() {
        return marca;
    }

    public Double getPrice() {
        return price;
    }
}
