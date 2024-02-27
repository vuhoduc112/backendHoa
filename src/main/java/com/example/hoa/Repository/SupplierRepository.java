package com.example.hoa.Repository;

import com.example.hoa.Entity.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Suppliers, Long> {
}
