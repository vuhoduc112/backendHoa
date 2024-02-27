package com.example.hoa.Controller;

import com.example.hoa.Entity.Customers;
import com.example.hoa.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAll")
     public ResponseEntity<List<Customers>> getAll() {
        List<Customers> customers = customerService.getAll();
        return ResponseEntity.ok().body(customers);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Customers> getById( @PathVariable Long id){
        Customers customers = customerService.getById(id);
        return ResponseEntity.ok().body(customers);
    }

    @GetMapping("/getByUserId/{id}")
    public ResponseEntity<Customers> getByUserId(@PathVariable Long id) {
        Customers customers = customerService.getbyUserID(id);
        return ResponseEntity.ok().body(customers);
    }

    @PostMapping("/create")
    public ResponseEntity<Customers> createCustomer(@RequestBody Customers customers){
        Customers customers1 = customerService.createCustomer(customers);
        return ResponseEntity.ok().body(customers1);
    }

    @PostMapping("/createByUserID/{id}")
    public ResponseEntity<Customers> createCustomerByUserID(@RequestBody Customers customers, @PathVariable Long id){
        Customers customers1 = customerService.createByUserID(customers, id);
        return ResponseEntity.ok().body(customers1);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customers> updateCustomer(@RequestBody Customers customers, @PathVariable Long id) {
        Customers customers1 = customerService.updateCustomer(customers, id);
        return ResponseEntity.ok().body(customers1);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Customers> deleteCustomer(@PathVariable Long id){
        Optional<Customers> customers = customerService.deleteCustomer(id);
        if(customers.isPresent()){
            return ResponseEntity.ok().body(customers.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
