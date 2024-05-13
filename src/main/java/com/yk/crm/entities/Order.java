package com.yk.crm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;
    @Column(name= "total_amount")
    private double total_amount;
    @Column(name= "service_start_date")
    private Date serviceStartDate;

    @ManyToOne()
    @JoinColumn(name = "service_address_id")
    private ServiceAddress serviceAddress;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProduct;

    @OneToOne(mappedBy = "order")
    private Bill bill;

}
