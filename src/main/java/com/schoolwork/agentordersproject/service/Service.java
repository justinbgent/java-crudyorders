package com.schoolwork.agentordersproject.service;

import com.schoolwork.agentordersproject.model.Agent;
import com.schoolwork.agentordersproject.model.Customer;
import com.schoolwork.agentordersproject.model.Order;

import java.util.List;

public interface Service {
    List<Customer> getCustomersWithOrders();

    Customer getCustomerById(long id);

    List<Customer> getCustomersLikeName(String likename);

    Agent getAgentById(long id);

    Order getOrderById(long id);

    Agent saveAgent(Agent agent);

    Customer saveCustomer(Customer customer);

    Order saveOrder(Order order);

    Order updateOrder(Order order, long ordnum);

    Customer updateCustomer(Customer customer, long custcode);

    void deleteCustomer(long custcode);

    void deleteOrder(long ordnum);

//    void addAgent(Agent agent);
//
//    void addCustomer(Customer customer);
//
//    void addOrder(Order order);
}
