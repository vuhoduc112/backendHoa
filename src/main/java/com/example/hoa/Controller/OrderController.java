    package com.example.hoa.Controller;

    import com.example.hoa.Entity.Orders;
    import com.example.hoa.Service.OrderService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.time.LocalDate;
    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequestMapping("/order")
    public class OrderController {
        @Autowired
        private OrderService orderService;

        @GetMapping("/getAll")
        public ResponseEntity<List<Orders>> getAll(){
            List<Orders> orders1 = orderService.getAll();
            return ResponseEntity.ok().body(orders1);
        }

        @GetMapping("/get/{id}")
        public ResponseEntity<Orders> getById(@PathVariable Long id) {
            Optional<Orders> orders = orderService.getById(id);
            if(orders.isPresent()){
                return ResponseEntity.ok().body(orders.get());
            }
            else {
               return ResponseEntity.notFound().build();
            }
        }

        @GetMapping("/getOrder/user-{userID}")
        public ResponseEntity<List<Orders>> findByUserID(@PathVariable Long userID) {
            List<Orders> orders = orderService.findByUserID(userID);
            if(orders.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            else {
                return ResponseEntity.ok().body(orders);
            }
        }


        @PostMapping("/create")
        public ResponseEntity<Orders> createOrder(@RequestBody Orders orders, @RequestParam Long userID, @RequestParam Long flowerID) {
            Orders orders1 = orderService.createOrder(orders, userID, flowerID);
            return new ResponseEntity<>(orders1, HttpStatus.CREATED);
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<Orders> updateOrder(@RequestBody Orders orders, @PathVariable Long id){
            Orders orders1 = orderService.updateOrder(orders, id);
            if(orders !=null){
                return ResponseEntity.ok().body(orders1);
            }
            else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Orders> deleteOrder(@PathVariable Long id){
            Orders orders1 = orderService.deleteOrder(id);
            if(orders1!=null){
                return  ResponseEntity.ok().body(orders1);
            }
            else {
                return  ResponseEntity.notFound().build();
            }
        }

        @GetMapping("/findFullname/{fullname}")
        public ResponseEntity<List<Orders>> findByUsername(@PathVariable String fullname){
            List<Orders> orders = orderService.findByFullname(fullname);
            return ResponseEntity.ok().body(orders);
        }

        @GetMapping("/findTrangThai/{trangthai}")
        public ResponseEntity<List<Orders>> findByTrangThai(@PathVariable String trangthai){
            List<Orders> orders = orderService.findByTrangThai(trangthai);
            return ResponseEntity.ok().body(orders);
        }

        @GetMapping("/findByOrderDateBetween")
        public ResponseEntity<Page<Orders>> findByOrderDateBetween(@RequestParam("startDate") String startDateStr, @RequestParam("endDate") String endDateStr, Pageable pageable){
            LocalDate startDate = LocalDate.parse(startDateStr);
            LocalDate endDate = LocalDate.parse(endDateStr);
            Page<Orders> orders = orderService.findByOrderDateBetween(startDate, endDate, pageable);
            return ResponseEntity.ok().body(orders);
        }
    }

