package com.example.hoa.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contactID")
    private Long contactID;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "numberPhone")
    private String numberPhone;

    @Column(name = "description")
    private String desc;

}
