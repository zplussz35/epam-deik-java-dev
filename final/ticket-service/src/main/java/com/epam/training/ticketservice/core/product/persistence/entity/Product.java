package com.epam.training.ticketservice.core.product.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String name;
    private Double netPriceAmount;
    private String netPriceCurrencyCode;

    public Product(String name, Double netPriceAmount, String netPriceCurrencyCode) {
        this.name = name;
        this.netPriceAmount = netPriceAmount;
        this.netPriceCurrencyCode = netPriceCurrencyCode;
    }
}
