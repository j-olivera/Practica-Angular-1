package com.component.pc.infrasctructure.persistence;

import com.component.pc.domain.enums.Marca;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name="ComponentPC")
public class ComponentPcEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column()
    private String piece_name;
    @Column()
    private Marca marca;
    @Column()
    private Double price;

    public ComponentPcEntity(Long id, String piece_name, Marca marca, Double price) {
        this.id = id;
        this.piece_name = piece_name;
        this.marca = marca;
        this.price = price;
    }
    public ComponentPcEntity() {}

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

