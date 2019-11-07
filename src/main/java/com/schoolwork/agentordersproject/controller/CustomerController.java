package com.schoolwork.agentordersproject.controller;

import com.schoolwork.agentordersproject.model.Customer;
import com.schoolwork.agentordersproject.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private Service service;

    // http://localhost:2019/customers/orders
    @GetMapping(value = "/orders", produces = {"application/json"})
    ResponseEntity<?> getCustomersWithOrders(){
        List<Customer> orders = service.getCustomersWithOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // http://localhost:2019/customers/customer/{custcode}
    @GetMapping(value = "/customer/{custcode}", produces = {"application/json"})
    ResponseEntity<?> getCustomerById(@PathVariable long custcode){
        Customer customer = service.getCustomerById(custcode);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    // http://localhost:2019/customers/namelike/{likename}
    @GetMapping(value = "/namelike/{likename}", produces = {"application/json"})
    ResponseEntity<?> getCustomersByLikeName(@PathVariable String likename){
        List<Customer> customers = service.getCustomersLikeName(likename);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
