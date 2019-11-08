package com.schoolwork.agentordersproject.controller;

import com.schoolwork.agentordersproject.model.Order;
import com.schoolwork.agentordersproject.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private Service service;

    // http://localhost:2019/orders/order/{orderid}
    @GetMapping(value = "/order/{orderid}", produces = {"application/json"})
    ResponseEntity<?> getOrderById(@PathVariable long orderid){
        Order order = service.getOrderById(orderid);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }


    /*
    {
   "ordamount" : 3.21,
   "advanceamount" : 1.23,
   "orderdescription" : "My New Order",
   "customer":
   {
       "custcode":18
   },
   "payments": [
   {
       "paymentid": 4
   }
   ]
}
    */
    // http://localhost:2019/orders/order
    @PostMapping(value = "/order", consumes = {"application/json"})
    public ResponseEntity<?> addOrder(@Valid @RequestBody Order order){
        order = service.saveOrder(order);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{ordnum}")
                .buildAndExpand(order.getOrdnum())
                .toUri();
        responseHeaders.setLocation(newCustomerURI);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    // http://localhost:2019/orders/order/{ordnum}
    @PutMapping(value = "/order/{ordnum}", consumes = {"application/json"})
    public ResponseEntity<?> updateOrder(@RequestBody Order order, @PathVariable long ordnum){
        service.updateOrder(order, ordnum);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // http://localhost:2019/orders/order/{ordnum}
    @DeleteMapping(value = "/order/{ordnum}")
    public ResponseEntity<?> deleteOrder(@PathVariable long ordnum){
        service.deleteOrder(ordnum);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
