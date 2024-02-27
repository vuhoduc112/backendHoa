package com.example.hoa.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private Long customerID;

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private Users user;

    @Column(name = "Address")
    private String address;

    @Column(name = "Company")
    private String company;

    @Column(name = "Zip Code")
    private String zipcode;

    @Column(name = "City")
    private String city;

    @Column(name = "Note")
    private String note;



}
