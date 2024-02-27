package com.example.hoa.Service.ServiceImpl;

import com.example.hoa.Entity.Customers;
import com.example.hoa.Entity.Orders;
import com.example.hoa.Entity.Users;
import com.example.hoa.Repository.CustomerRepository;
import com.example.hoa.Repository.OrderRepository;
import com.example.hoa.Repository.UsersRepository;
import com.example.hoa.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Customers> getAll() {
        List<Customers> customersList = customerRepository.findAll();
        return customersList;
    }

    @Override
    public Customers getById(Long id) {
        Customers customers = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy id"));
        return customers;
    }

    @Override
    public Customers createCustomer(Customers customers) {
        Customers customers1 = customerRepository.save(customers);
        return customers1;
    }

    @Override
    public Customers createByUserID(Customers customers, Long userid) {
        Customers customers1 = customerRepository.findByUserID(userid);
        if(customers1!=null){
            return customerRepository.save(customers);
        }
        return null;
    }


    @Override
    public Customers getbyUserID(Long id) {
        Customers customers = customerRepository.findByUserID(id);
        return customers;
    }

    @Override
    public Customers updateCustomer(Customers customers, Long id) {
        Customers customers1 = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy CustomerID"));
        customers1.setAddress(customers.getAddress());
        customers1.setCity(customers.getCity());
        customers1.setNote(customers.getNote());
        customers1.setCompany(customers.getCompany());
        customers1.setZipcode(customers.getZipcode());
        Customers customers2 = customerRepository.save(customers1);
        return customerRepository.save(customers2);
    }

    @Override
    public Optional<Customers> deleteCustomer(Long id) {
        Optional<Customers> customers = customerRepository.findById(id);
        if(customers.isPresent()){
            customerRepository.deleteById(id);
            return Optional.of(customers.get());
        }
        else {
            throw new RuntimeException("Không xóa được người dùng");
        }
    }
}
