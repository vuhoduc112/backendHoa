package com.example.hoa.Service;

import com.example.hoa.Entity.Suppliers;

import java.util.List;
import java.util.Optional;

public interface SupplierService {

    List<Suppliers> getAll();

    Optional<Suppliers> getById(Long id);

    Suppliers createSuppliers(Suppliers suppliers);

    Suppliers updateSuppliers(Suppliers suppliers, Long id);

    Optional<Suppliers> deleteSuppliers(Long id);
}
