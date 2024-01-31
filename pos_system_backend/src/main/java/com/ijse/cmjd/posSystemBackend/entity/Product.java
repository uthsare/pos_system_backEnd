package com.ijse.cmjd.posSystemBackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String productName;



    private Double unitPrice;

    private int inStockQTY;



    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name="category_id")
    private Category category;

}
