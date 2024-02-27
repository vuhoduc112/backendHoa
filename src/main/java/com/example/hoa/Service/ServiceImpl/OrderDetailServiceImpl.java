package com.example.hoa.Service.ServiceImpl;

import com.example.hoa.Entity.Flowers;
import com.example.hoa.Entity.OrderDetail;
import com.example.hoa.Entity.Orders;
import com.example.hoa.Repository.FlowerRepository;
import com.example.hoa.Repository.OrderDetailRepository;
import com.example.hoa.Repository.OrderRepository;
import com.example.hoa.Service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private  OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private FlowerRepository flowerRepository;

    @Override
    public List<OrderDetail> getAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public Optional<OrderDetail> getById(Long id) {
        return orderDetailRepository.findById(id);
    }

    @Override
    public OrderDetail createOrderDetail(OrderDetail orderDetail, Long orderId, Long flowerId) {
        Orders orders = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Không tìm thấy OrderId"));
        Flowers flowers = flowerRepository.findById(flowerId).orElseThrow(() -> new RuntimeException("Không tìm thấy flowerId"));
        orderDetail.setFlower(flowers);
        orderDetail.setOrder(orders);
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetail orderDetail, Long orderDetailId) {
        OrderDetail orderDetail1 = orderDetailRepository.findById(orderDetailId).orElseThrow(() -> new RuntimeException("Không tìm thấy orderDetailId"));
        orderDetail1.setQuantity(orderDetail.getQuantity());
        return  orderDetailRepository.save(orderDetail1);
    }

    @Override
    public OrderDetail deleteOrderDetail(Long orderDetailId) {
        OrderDetail orderDetail = orderDetailRepository.findById(orderDetailId).orElseThrow(() -> new RuntimeException("Không tìm thấy id"));
        if(orderDetail!=null){
            orderDetailRepository.deleteById(orderDetailId);
            return orderDetail;
        }
        else {
            throw new RuntimeException("Lỗi xóa sản phẩm");
        }
    }
}
