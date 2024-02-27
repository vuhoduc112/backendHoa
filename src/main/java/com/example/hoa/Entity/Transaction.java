package com.example.hoa.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Transaction")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionID")
    private Long  transactionId;
    @Column(name = "PaymentMethod")
    private String paymentMethod;
    @Column(name = "Amount")
    private double amount;
    @Column(name = "Status")
    private String status;
    @Column(name = "Timestamp")
    private Date timestamp;
    @Column(name = "PayerID")
    private String payerId;
    @Column(name = "PaymentStatus")
    private String paymentStatus;
}
