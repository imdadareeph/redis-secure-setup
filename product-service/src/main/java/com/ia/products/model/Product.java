package com.ia.products.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Persistable<Long> {
    @Id
    private Long id;
    private String description;
    private double price;
    @Column("quantity_available")
    private int quantityAvailable;

    @Transient
    private boolean newProduct;

    public Product(String description, double price, int quantityAvailable) {
        this.description = description;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
        this.newProduct = true;
    }

    @Override
    @Transient
    public boolean isNew() {
        return this.newProduct || id == null;
    }
}