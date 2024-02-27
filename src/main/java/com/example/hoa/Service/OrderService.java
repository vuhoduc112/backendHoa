package com.example.hoa.Service;

import com.example.hoa.Entity.Orders;
import com.example.hoa.Entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Orders> getAll();

    Optional<Orders> getById(Long id);

    Orders createOrder(Orders orders, Long userId, Long flowerId);

    Orders updateOrder(Orders orders, Long orderId);

    Orders deleteOrder(Long orderId);

    List<Orders> findByUserID(Long userID);

    List<Orders> findByFullname(String username);

    List<Orders> findByTrangThai(String trangThai);

    Page<Orders> findByOrderDateBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);



}
