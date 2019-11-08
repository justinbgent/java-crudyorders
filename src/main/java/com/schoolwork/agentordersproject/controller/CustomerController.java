package com.schoolwork.agentordersproject.controller;

import com.schoolwork.agentordersproject.model.Customer;
import com.schoolwork.agentordersproject.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    // http://localhost:2019/customers/customer
    /*
    {
        "custname": "John",
        "custcity": "Port Angeles",
        "workingarea": "Washington",
        "custcountry": "USA",
        "grade": "1",
        "openingamt": 70000,
        "receiveamt": 7000,
        "paymentamt": 777,
        "outstandingamt": 0,
        "phone": "5555555555",
        "agent": {
    },
        "orders": [
        {
            "ordamount": 7777,
            "advanceamount": 777,
            "orderdescription": "SOD"
        }
        ]
}
    */
    @PostMapping(value = "/customer", consumes = {"application/json"})
    public  ResponseEntity<?> addCustomer(@Valid @RequestBody Customer customer){
        customer = service.saveCustomer(customer);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{custcode}")
                .buildAndExpand(customer.getCustcode())
                .toUri();
        responseHeaders.setLocation(newCustomerURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    // http://localhost:2019/customers/customer/{custcode}
    @PutMapping(value = "/customer/{custcode}", consumes = {"application/json"})
    public ResponseEntity<?> updateCustomer(@RequestBody Customer updateCustomer,
                                              @PathVariable long custcode){
        service.updateCustomer(updateCustomer, custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // http://localhost:2019/customers/customer/{custcode}
    @DeleteMapping(value = "/customer/{custcode}", consumes = {"application/json"})
    public ResponseEntity<?> deleteCustomer(@RequestBody@PathVariable long custcode){
        service.deleteCustomer(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
