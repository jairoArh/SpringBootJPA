package com.example.demo.controlers;

import com.example.demo.entities.Customer;
import com.example.demo.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers(){

        return customerService.getAllCustomers();
    }

    @PostMapping
    public Customer newCustomer(@RequestBody Customer customer ){

        return customerService.newCustomer( customer );
    }
}
