package com.ijse.cmjd.posSystemBackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String categoryName;
    // product list
    @OneToMany(fetch =FetchType.LAZY,mappedBy = "category",cascade=CascadeType.ALL)
    private List<Product> products;
}
