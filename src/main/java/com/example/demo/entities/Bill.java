package com.example.demo.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private double total;

    @Column(name = "date_bill", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateBill;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Bill() {
    }

    public Bill(Integer id,  double total) {
        this.id = id;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getDateBill() {
        return dateBill;
    }

    public void setDateBill(LocalDate dateBill) {
        this.dateBill = dateBill;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Double.compare(bill.total, total) == 0 && id.equals(bill.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", total=" + total +
                ", fecha=" + dateBill +
                '}';
    }
}
