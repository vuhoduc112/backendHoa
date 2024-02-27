package com.example.hoa.Repository;

import com.example.hoa.Entity.Customers;
import com.example.hoa.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customers, Long> {
    @Query("SELECT o FROM Customers o WHERE o.user.userID = :userID")
    Customers findByUserID(Long userID);
}
