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
}
