//package com.example.hoa.Controller;
//
//import com.example.hoa.Entity.Pay;
//import com.example.hoa.Service.PayService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("/pay")
//public class PayController {
//
//    @Autowired
//    private PayService payService;
//
//    @GetMapping("/getAll")
//    public ResponseEntity<List<Pay>> getAll() {
//        return ResponseEntity.ok(payService.getAll());
//    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<Pay> getById(@PathVariable Long id) {
//        return ResponseEntity.of(payService.getById(id));
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<Pay> createPay(@RequestBody Pay pay, @RequestParam Long userID, @RequestParam List<Long> orderIDs) {
//        Pay createdPay = payService.createPay(pay, userID, orderIDs);
//        return new ResponseEntity<>(createdPay, HttpStatus.CREATED);
//    }
//
//
//
//
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Pay> updatePay(@RequestBody Pay pay, @PathVariable Long id) {
//        return ResponseEntity.ok(payService.updatePay(pay, id));
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Pay> deletePay(@PathVariable Long id) {
//        return ResponseEntity.ok(payService.deletePay(id));
//    }
//}
