package com.example.hoa.Repository;
import com.example.hoa.Entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Query("SELECT o FROM Orders o WHERE o.user.userID = :userID AND o.flower.flowerId = :flowerID")
    Optional<Orders> findByUserUserIDAndFlower(Long userID, Long flowerID);

    @Query("SELECT o FROM Orders o WHERE o.user.userID = :userID")
    List<Orders> findByUserID(Long userID);
    @Query("SELECT o FROM Orders o WHERE o.user.fullname = :fullname")
    List<Orders> findbyUsername(String fullname);

    @Query("SELECT o FROM Orders o WHERE o.trangThai = :trangThai")
    List<Orders> findByTrangThai(String trangThai);

    Page<Orders> findByOrderDateBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);

}

