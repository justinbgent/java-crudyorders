package com.schoolwork.agentordersproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private long ordnum;

    @Column(nullable = true)
    private double ordamount;
    private double advanceamount;
    private String orderdescription;

    @Transient
    public Boolean hasOrdAmountValue = false;
    @Transient
    public Boolean hasAdvanceAmtValue = false;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnoreProperties("orders")
    private Customer customer;

//    @OneToMany
//    @JoinTable(name = "orderspayments",
//            joinColumns = @JoinColumn(name = "ordnum"),
//            inverseJoinColumns = @JoinColumn(name = "paymentid"))
//            @JsonIgnoreProperties("orders")
//    private List<Payment> payments = new ArrayList<>();

    public Order() { }

    public Order(double ordamount, double advanceamount, String orderdescription, Customer customer) {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.orderdescription = orderdescription;
        this.customer = customer;
    }

    public long getOrdnum() { return ordnum; }

    public void setOrdnum(long ordnum) { this.ordnum = ordnum; }

    public double getOrdamount() { return ordamount; }

    public void setOrdamount(double ordamount) {
        hasOrdAmountValue = true;
        this.ordamount = ordamount; }

    public double getAdvanceamount() { return advanceamount; }

    public void setAdvanceamount(double advanceamount) {
        hasAdvanceAmtValue = true;
        this.advanceamount = advanceamount; }

    public String getOrderdescription() { return orderdescription; }

    public void setOrderdescription(String orderdescription) { this.orderdescription = orderdescription; }

    public Customer getCustomer() { return customer; }

    public void setCustomer(Customer customer) { this.customer = customer; }
}
