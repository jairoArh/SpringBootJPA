package com.example.demo.controlers;

import com.example.demo.entities.Bill;
import com.example.demo.services.BillService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillControler {

    private BillService billService;

    public BillControler(BillService billService) {
        this.billService = billService;
    }

    @GetMapping
    public List<Bill> getAllBills(){
        return billService.getAllBills();
    }

    @PostMapping
    public Bill newBill(@RequestBody Bill bill ){

        return billService.addBill( bill );

    }

    @GetMapping("/getBillsCustomer/{id}")
    public List<Bill> getBillsCustomer( @PathVariable int id){
        return billService.getBillsCustomer( id );
    }

}
