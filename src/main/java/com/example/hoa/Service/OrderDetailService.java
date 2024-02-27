package com.example.hoa.Service;

import com.example.hoa.Entity.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    List<OrderDetail> getAll();

    Optional<OrderDetail> getById(Long id);

    OrderDetail createOrderDetail(OrderDetail orderDetail, Long orderId, Long flowerId);

    OrderDetail updateOrderDetail(OrderDetail orderDetail, Long id);

    OrderDetail deleteOrderDetail(Long id);
}
