package com.example.hoa.Service.ServiceImpl;

import com.example.hoa.Entity.Suppliers;
import com.example.hoa.Repository.SupplierRepository;
import com.example.hoa.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;
    @Override
    public List<Suppliers> getAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Optional<Suppliers> getById(Long id) {
        return supplierRepository.findById(id);
    }

    @Override
    public Suppliers createSuppliers(Suppliers suppliers) {
        return supplierRepository.save(suppliers);
    }

    @Override
    public Suppliers updateSuppliers(Suppliers suppliers, Long id) {
      Suppliers suppliers1 = supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy id"));
      suppliers1.setCompanyName(suppliers.getCompanyName());
      suppliers1.setName(suppliers.getName());
      suppliers1.setEmail(suppliers.getEmail());
      suppliers1.setAddress(suppliers.getAddress());
      suppliers1.setPhone(suppliers.getPhone());

        return supplierRepository.save(suppliers1);
    }

    @Override
    public Optional<Suppliers> deleteSuppliers(Long id) {
        Optional<Suppliers> suppliers = supplierRepository.findById(id);
        if(suppliers.isPresent()){supplierRepository.deleteById(id);
        }
        return null;
    }
}
