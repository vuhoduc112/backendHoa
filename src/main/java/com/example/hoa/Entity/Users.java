package com.example.hoa.Entity;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Long userID;
    @Column(name = "Username")
    private String username;
    @Column(name = "Fullname")
    private String fullname;
    @Column(name = "Password")
    private String password;
    @Column(name = "ResetToken")
    private String resetToken;
    @Column(name = "Email", unique = true)
    private String email;
    @Column(name = "SĐT")
    private String sdt;
    @Column(name = "Address")
    private String address;
    @Column(name = "Company")
    private String company;
    @Column(name = "Zip Code")
    private String zipcode;
    @Column(name = "Note")
    private String note;
    @Column(name = "Role")
    private String role;


}
