package com.example.hoa.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "flowers")
public class Flowers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FlowerID")
    private Long flowerId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String desc;

    @Column(name = "PriceOld")
    private Integer priceOld;

    @Column(name = "PriceNew")
    private Integer priceNew;

    @Column(name = "ImageURL")
    private String imageURL;

    @Column(name = "FlowersType")
    private String flowersType;

    @Column(name = "Amount")
    private String amount;

}
