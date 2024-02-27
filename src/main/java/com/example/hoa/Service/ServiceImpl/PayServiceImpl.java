//package com.example.hoa.Service.ServiceImpl;
//
//import com.example.hoa.Entity.Flowers;
//import com.example.hoa.Entity.Orders;
//import com.example.hoa.Entity.Pay;
//import com.example.hoa.Entity.Users;
//import com.example.hoa.Repository.FlowerRepository;
//import com.example.hoa.Repository.OrderRepository;
//import com.example.hoa.Repository.PayRepository;
//import com.example.hoa.Repository.UsersRepository;
//import com.example.hoa.Service.PayService;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class PayServiceImpl implements PayService {
//
//    @Autowired
//    private PayRepository payRepository;
//
//    @Autowired
//    private UsersRepository usersRepository;
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @Autowired
//    private FlowerRepository flowerRepository;
//
//    @Override
//    public List<Pay> getAll() {
//        return payRepository.findAll();
//    }
//
//    @Override
//    public Optional<Pay> getById(Long id) {
//        return payRepository.findById(id);
//    }
//
//
//    @Override
//    public Pay createPay(Pay pay, Long userID, List<Long> orderIDs) {
//        Users user = usersRepository.findById(userID)
//                .orElseThrow(() -> new RuntimeException("Không tìm thấy ID người dùng"));
//
//        List<Orders> orders = orderRepository.findAllById(orderIDs);
//        // Kiểm tra xem có đơn hàng nào không tồn tại không
//        if (orders.size() != orderIDs.size()) {
//            throw new RuntimeException("Một hoặc nhiều đơn hàng không tồn tại");
//        }
//
//        // Thiết lập mối quan hệ giữa Pay và Orders
//        pay.setUser(user);
//        pay.setOrders(orders);
//
//        // Lưu Pay mới
//        return payRepository.save(pay);
//    }
//
//
//
//    @Override
//    public Pay updatePay(Pay pay, Long id) {
//        Pay existingPay = payRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy Pay với ID: " + id));
//        existingPay.setDatePay(pay.getDatePay());
//        existingPay.setMoney(pay.getMoney());
//        existingPay.setPhuongthuc(pay.getPhuongthuc());
//        return payRepository.save(existingPay);
//    }
//
//    @Override
//    public Pay deletePay(Long id) {
//        Pay existingPay = payRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy Pay với ID: " + id));
//        payRepository.delete(existingPay);
//        return existingPay;
//    }
//}
