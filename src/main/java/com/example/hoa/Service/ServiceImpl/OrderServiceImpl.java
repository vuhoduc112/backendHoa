package com.example.hoa.Service.ServiceImpl;
import com.example.hoa.Entity.Flowers;
import com.example.hoa.Entity.Orders;
import com.example.hoa.Entity.Users;
import com.example.hoa.Repository.FlowerRepository;
import com.example.hoa.Repository.OrderRepository;
import com.example.hoa.Repository.UsersRepository;
import com.example.hoa.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private FlowerRepository flowerRepository;

    @Override
    public List<Orders> getAll() {
        return orderRepository.findAll();
    }
    @Override
    public Optional<Orders> getById(Long id) {

        Optional<Orders> orders = orderRepository.findById(id);
        if(orders.isPresent()){
            return orders;
        }
        else {
            throw new RuntimeException("Không tìm thấy id");
        }
    }

    @Override
    public List<Orders> findByUserID( Long userID) {
        List<Orders> orders1 = orderRepository.findByUserID(userID);
        return orders1;
    }

    @Override
    public List<Orders> findByFullname(String username) {
        return orderRepository.findbyUsername(username);
    }

    @Override
    public List<Orders> findByTrangThai(String trangThai) {
        return orderRepository.findByTrangThai(trangThai);
    }

    @Override
    public Page<Orders> findByOrderDateBetween(LocalDate startDate, LocalDate endDate, Pageable pageable) {

        return orderRepository.findByOrderDateBetween(startDate, endDate, pageable);
    }


    @Override
    public Orders createOrder(Orders orders, Long userID, Long flowerID) {
        Users users = usersRepository.findById(userID).orElseThrow(() -> new RuntimeException("Không tìm thấy ID người dùng"));
        Flowers flowers = flowerRepository.findById(flowerID).orElseThrow(() -> new RuntimeException("Không tìm thấy ID sản phẩm"));
        Optional<Orders> orders1 = orderRepository.findByUserUserIDAndFlower(userID, flowerID);
        if(orders1.isPresent()){
            Orders currentOrders = orders1.get();
            currentOrders.setQuantity(currentOrders.getQuantity() + 1);
            currentOrders.setOrderDate(LocalDate.now());
            currentOrders.setTrangThai(orders.getTrangThai());
            return orderRepository.save(currentOrders);
        }
        else {
            Orders newOrders = new Orders();
            newOrders.setFlower(flowers);
            newOrders.setUser(users);
            newOrders.setQuantity(1);
            newOrders.setOrderDate(LocalDate.now());
            newOrders.setTrangThai(orders.getTrangThai());
            return orderRepository.save(newOrders);
        }
    }



    @Override
    public Orders updateOrder(Orders orders, Long orderId) {
      Orders orders1 = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("không tìm thấy Orderid"));
      orders1.setOrderDate(orders.getOrderDate());
      orders1.setQuantity(orders.getQuantity());
      orders1.setPhuongThuc(orders.getPhuongThuc());
      orders1.setTrangThai(orders.getTrangThai());
      orders1.setNote(orders.getNote());
        return orderRepository.save(orders1);
    }

    @Override
    public Orders deleteOrder(Long orderID) {
        Optional<Orders> deleteOrder = orderRepository.findById(orderID);
        if(deleteOrder.isPresent()){
            orderRepository.deleteById(orderID);
            return deleteOrder.get();
        }
        else {
            throw new RuntimeException("Lỗi xóa đơn hàng");
        }
    }

}
