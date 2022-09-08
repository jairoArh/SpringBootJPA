package com.example.demo.services;

import com.example.demo.entities.Bill;
import com.example.demo.entities.Customer;
import com.example.demo.repositories.BillRepository;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer newCustomer( Customer customer ){
        return customerRepository.save( customer );
    }

    public List<Bill> getBills(int id){
        return null;
    }

}

