package com.example.hoa.Controller;

import com.example.hoa.Entity.Contact;
import com.example.hoa.Entity.Suppliers;
import com.example.hoa.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Suppliers>> getAll() {
        List<Suppliers> suppliers = supplierService.getAll();
        return ResponseEntity.ok().body(suppliers);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Suppliers>> getById(@PathVariable Long id) {
        Optional<Suppliers> suppliers = supplierService.getById(id);
        return ResponseEntity.ok().body(suppliers);
    }

    @PostMapping("/create")
    public ResponseEntity<Suppliers> createSuppliers(@RequestBody Suppliers suppliers) {
        Suppliers suppliers1 = supplierService.createSuppliers(suppliers);
        return ResponseEntity.ok().body(suppliers1);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Suppliers> updateSuppliers( @RequestBody Suppliers suppliers, @PathVariable Long id){
        Suppliers suppliers1 = supplierService.updateSuppliers(suppliers, id);
        return ResponseEntity.ok().body(suppliers1);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Suppliers>> deleteSuppliers(@PathVariable Long id){
        Optional<Suppliers> suppliers = supplierService.deleteSuppliers(id);
        return ResponseEntity.ok().body(suppliers);
    }
}
