package com.yk.crm.entities;

import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "prod_char")
    private String prodChar;
    @Column(name = "product_price")
    private double productPrice;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private ProductCategory productCategory;

    @OneToOne(mappedBy = "product")
    private Stock stock;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderProduct;
}
