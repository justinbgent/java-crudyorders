package com.schoolwork.agentordersproject.service;

import com.schoolwork.agentordersproject.model.Agent;
import com.schoolwork.agentordersproject.model.Customer;
import com.schoolwork.agentordersproject.model.Order;
import com.schoolwork.agentordersproject.repos.AgentRepo;
import com.schoolwork.agentordersproject.repos.CustomerRepo;
import com.schoolwork.agentordersproject.repos.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service(value = "service")
public class ServiceImplementation implements com.schoolwork.agentordersproject.service.Service {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private AgentRepo agentRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Override
    public List<Customer> getCustomersWithOrders() {
        return customerRepo.getAllBy();
    }

    @Override
    public Customer getCustomerById(long id) {
        return customerRepo.getByCustcode(id);
    }

    @Override
    public List<Customer> getCustomersLikeName(String likename) {
        List<Customer> list = customerRepo.findByCustnameContainingIgnoringCase(likename);
        if(list.isEmpty()){
            throw new EntityNotFoundException("List is empty");
        }
        return list;
    }

    @Override
    public Agent getAgentById(long id) {
        return agentRepo.getByAgentcode(id);
    }

    @Override
    public Order getOrderById(long id) {
        return orderRepo.getByOrdnum(id);
    }
}
