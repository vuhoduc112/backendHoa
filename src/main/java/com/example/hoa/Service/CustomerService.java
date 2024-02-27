package com.example.hoa.Service;

import com.example.hoa.Entity.Customers;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customers> getAll();

    Customers getById(Long id);

    Customers createCustomer(Customers customers);

    Customers createByUserID(Customers customers, Long userid);

    Customers getbyUserID(Long id);

    Customers updateCustomer(Customers customers, Long id);

    Optional<Customers> deleteCustomer(Long id);

}
