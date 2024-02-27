package com.example.hoa.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private Long orderID;

    @ManyToOne
    @JoinColumn(name = "FlowerID", referencedColumnName = "FlowerID")
    private Flowers flower;

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private Users user;

    @Column(name = "trangThai")
    private String trangThai;

    @Column(name = "PhuongThuc")
    private String PhuongThuc;

    @Column(name = "OrderDate")
    private LocalDate orderDate;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Note")
    private String note;

}
