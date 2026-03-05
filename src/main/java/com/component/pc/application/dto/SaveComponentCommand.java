package com.component.pc.application.dto;

import com.component.pc.domain.enums.Marca;

public class SaveComponentCommand {
    // no id, la genera la BD
    private String piece_name;
    private Marca marca;
    private Double price;

    public String getPiece_name() {
        return piece_name;
    }

    public Marca getMarca() {
        return marca;
    }

    public Double getPrice() {
        return price;
    }

    public SaveComponentCommand(String piece_name, Marca marca, Double price) {
        this.piece_name = piece_name;
        this.marca = marca;
        this.price = price;
    }

    public void validate() {
        if (piece_name == null || marca == null || price == null) {
            throw new RuntimeException();
        }
    }

}
