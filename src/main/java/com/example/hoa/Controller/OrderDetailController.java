package com.example.hoa.Controller;

import com.example.hoa.Entity.OrderDetail;
import com.example.hoa.Service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/getAll")
    public ResponseEntity<List<OrderDetail>> getAll(){
        List<OrderDetail> details = orderDetailService.getAll();
        return ResponseEntity.ok().body(details);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<OrderDetail>> getById(@PathVariable Long id){
        Optional<OrderDetail> orderDetail =  orderDetailService.getById(id);
        return ResponseEntity.ok().body(orderDetail);
    }

    @PostMapping("/create/orderId-{orderId}/flowerId-{flowerId}")
    public ResponseEntity<OrderDetail> create(@RequestBody OrderDetail orderDetail,@PathVariable Long orderId, @PathVariable Long flowerId){
        OrderDetail orderDetail1 = orderDetailService.createOrderDetail(orderDetail, orderId, flowerId);
        return ResponseEntity.ok().body(orderDetail1);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrderDetail> update(@RequestBody OrderDetail orderDetail, @PathVariable Long id){
        OrderDetail orderDetail1 = orderDetailService.updateOrderDetail(orderDetail, id);
        if(orderDetail!=null){
            return ResponseEntity.ok().body(orderDetail1);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OrderDetail> delete(@PathVariable Long id){
        OrderDetail orderDetail = orderDetailService.deleteOrderDetail(id);
        if(orderDetail!= null){
            return ResponseEntity.ok().body(orderDetail);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
