//package com.example.hoa.Entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Data
//@Table(name = "Pay")
//public class Pay {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "PayID")
//    private Long payID;
//
//    @ManyToOne
//    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
//    private Users user;
//
//    @OneToMany(mappedBy = "pay", cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<Orders> orders;
//
//    @Column(name = "Money")
//    private Integer money;
//
//    @Column(name = "DatePay")
//    private LocalDate datePay;
//
//    @Column(name = "PhuongThuc")
//    private String phuongthuc;
//
//
//
//}
