package com.example.hoa.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "orderdetails")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderDetailID")
    private Long orderDetailId;

    @ManyToOne
    @JoinColumn(name = "FlowerID", referencedColumnName = "FlowerID")
    private Flowers flower;

    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
    private Orders order;

    @Column(name = "Quantity")
    private Integer quantity;
}
