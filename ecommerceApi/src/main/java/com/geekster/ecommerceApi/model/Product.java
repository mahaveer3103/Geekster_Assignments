package com.geekster.ecommerceApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="product_id")
    private Integer productId;
    @Column(name ="name")
    private String name;
    @Column(name ="price")
    private String price;
    @Column(name ="description")
    private String description;
    @Column(name ="category")
    private String category;
    @Column(name ="brand")
    private String brand;

}
