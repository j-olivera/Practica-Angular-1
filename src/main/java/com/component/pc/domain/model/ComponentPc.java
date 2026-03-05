package com.component.pc.domain.model;

import com.component.pc.domain.enums.Marca;

public class ComponentPc {
    private Long id;
    private String piece_name;
    private Marca marca;
    private Double price;

    private ComponentPc(Long id, String piece_name, Marca marca, Double price) {
        this.id = id;
        this.piece_name = piece_name;
        this.marca = marca;
        this.price = price;
    }

    public static ComponentPc createComponent(String piece_name, Marca marca, Double price) {
        return new ComponentPc(null, piece_name, marca, price);
    }
    public static ComponentPc reconstruir(Long id, String piece_name, Marca marca, Double price) {
        return new ComponentPc(id, piece_name, marca, price);
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
