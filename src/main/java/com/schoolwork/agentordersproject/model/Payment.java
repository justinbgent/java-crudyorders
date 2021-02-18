package com.schoolwork.agentordersproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "payments")
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentid;

    @Column(nullable = false)
    private String type;

//    @ManyToMany(mappedBy = "payments")
//    private List<Order> orders = new ArrayList<>();

    public Payment() { }

    public Payment(String type) { this.type = type; }

    public long getPaymentid() { return paymentid; }

    public void setPaymentid(long paymentid) { this.paymentid = paymentid; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }
}
