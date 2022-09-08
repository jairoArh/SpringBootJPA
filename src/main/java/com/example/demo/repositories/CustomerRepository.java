package com.example.demo.repositories;

import com.example.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select customer from Customer customer where customer.id =:id")
    Customer getCustomerById( int id );
}
