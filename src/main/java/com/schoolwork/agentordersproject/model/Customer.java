package com.schoolwork.agentordersproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private long custcode;

    @Column(nullable = false)
    private String custname;
    private String custcity;
    private String workingarea;
    private String custcountry;
    private String grade;
    private double openingamt;
    private double receiveamt;
    private double paymentamt;
    private double outstandingamt;
    private String phone;
    //private long agentcode;

    @Transient
    public Boolean hasopeningamtValue = false;
    @Transient
    public Boolean hasReceiveamtValue = false;
    @Transient
    public Boolean hasPaymentamtValue = false;
    @Transient
    public Boolean hasOutstandingamtValue = false;
    @Transient

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonIgnoreProperties("customer")
    List<Order> orders = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "agentcode",
            nullable = false)
    @JsonIgnoreProperties("customers")
    private Agent agent;

    public Customer() { }

    public Customer(String custname, String custcity, String workingarea, String custcountry, String grade, double openingamt, double receiveamt, double paymentamt, double outstandingamt, String phone, Agent agent) {
        this.custname = custname;
        this.custcity = custcity;
        this.workingarea = workingarea;
        this.custcountry = custcountry;
        this.grade = grade;
        this.openingamt = openingamt;
        this.receiveamt = receiveamt;
        this.paymentamt = paymentamt;
        this.outstandingamt = outstandingamt;
        this.phone = phone;
        this.agent = agent;
    }

    public long getCustcode() { return custcode; }

    public void setCustcode(long custcode) { this.custcode = custcode; }

    public String getCustname() { return custname; }

    public void setCustname(String custname) { this.custname = custname; }

    public String getCustcity() { return custcity; }

    public void setCustcity(String custcity) { this.custcity = custcity; }

    public String getWorkingarea() { return workingarea; }

    public void setWorkingarea(String workingarea) { this.workingarea = workingarea; }

    public String getCustcountry() { return custcountry; }

    public void setCustcountry(String custcountry) { this.custcountry = custcountry; }

    public String getGrade() { return grade; }

    public void setGrade(String grade) { this.grade = grade; }

    public double getOpeningamt() { return openingamt; }

    public void setOpeningamt(double openingamt) {
        hasopeningamtValue = true;
        this.openingamt = openingamt; }

    public double getReceiveamt() { return receiveamt; }

    public void setReceiveamt(double receiveamt) {
        hasReceiveamtValue = true;
        this.receiveamt = receiveamt; }

    public double getPaymentamt() { return paymentamt; }

    public void setPaymentamt(double paymentamt) {
        hasPaymentamtValue = true;
        this.paymentamt = paymentamt; }

    public double getOutstandingamt() { return outstandingamt; }

    public void setOutstandingamt(double outstandingamt) {
        hasOutstandingamtValue = true;
        this.outstandingamt = outstandingamt; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public List<Order> getOrders() { return orders; }

    public void setOrders(List<Order> orders) { this.orders = orders; }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public void removeOrder(Order order){
        orders.remove(order);
    }
}
