package com.example.demo.services;

import com.example.demo.entities.Bill;
import com.example.demo.repositories.BillRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService {
    private BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    /**
     * Permite adicionar una nueva factura, se valida que el cliente al que se agrega la factura exista, de ser verdadero
     * agrega la factura y reorna el objeto de la factura, en caso contrario retorna `null`
     * @param bill Instancia de factura que se va a agregar
     * @return El objeto si se puede agregar, sino `null`
     */
    public Bill addBill(Bill bill){

        if( existsCustomer( bill.getCustomer().getId())){
            return billRepository.save( bill );
        }

        return null;

    }

    public List<Bill> getAllBills(){
        return billRepository.findAll();
    }

    public List<Bill> getBillsCustomer( int id ){


       /* List<Bill> bills = billRepository.findAll();
        List<Bill> billsCustomer = new ArrayList<>();
        for ( Bill bill : bills ){
            if ( bill.getCustomer().getId() == id ){
                billsCustomer.add( bill );
            }
        }

        List<Bill> billsCustomer = billRepository.findAll()
                .stream().filter( bill -> bill.getCustomer().getId() == id ).collect(Collectors.toList());*/

        return billRepository.getBillsCustomer( id );

    }

    /***
     * Método que valida si un cliente se encuentra registrado en la Base de Datos
     * @param id ID del Cliente
     * @return Verdadero si el tamaño de la colección > 0, es decir, el cliente existe, falso en caso contrario
     */
    private boolean existsCustomer( int id ){
        return billRepository.getCustomersById(id).size() > 0;
    }

}
