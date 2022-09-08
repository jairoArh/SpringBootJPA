package com.example.demo.repositories;

import com.example.demo.entities.Bill;
import com.example.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    @Query(value = "select bill from Bill bill where bill.customer.id=:id")
    List<Bill> getBillsCustomer( int id );

    /**
     * Definición de método que recibe un Id de Cliente y verifica si el cliente existe en la Base de Datos
     * Usa un JOIN entre las dos entidades
     * @param id ID del Cliente
     * @return Colección con el cliente (al validar el ID que es Llave primaria, retorna un solo registro)
     */
    @Query(value = "SELECT customer FROM Bill bill JOIN bill.customer customer where customer.id = :id")
    List<Customer> getCustomersById(int id );
}
