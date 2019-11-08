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
import javax.transaction.Transactional;
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

    @Transactional
    @Override
    public Agent saveAgent(Agent agent) {
        Agent newAgent = new Agent();

        newAgent.setAgentname(agent.getAgentname());
        newAgent.setAgentcode(agent.getAgentcode());
        newAgent.setCommission(agent.getCommission());
        newAgent.setCountry(agent.getCountry());
        //newAgent.setCustomers(agent.getCustomers());
        newAgent.setPhone(agent.getPhone());
        newAgent.setWorkingarea(agent.getWorkingarea());

        for (Customer c : agent.getCustomers()){
            Customer newCust = customerRepo.getByCustcode(c.getCustcode());

            newAgent.addCustomer(newCust);
        }

        return agentRepo.save(newAgent);
    }

    @Transactional
    @Override
    public Customer saveCustomer(Customer customer) {
        Customer newCustomer = new Customer();

        newCustomer.setAgent(customer.getAgent());
        newCustomer.setCustcode(customer.getCustcode());
        newCustomer.setCustname(customer.getCustname());
        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPhone(customer.getPhone());
        //newCustomer.setOrders(customer.getOrders());
        newCustomer.setAgent(customer.getAgent());

        for (Order o : customer.getOrders()){
            Order newOrder = orderRepo.getByOrdnum(o.getOrdnum());
            newCustomer.addOrder(newOrder);
        }

        return customerRepo.save(newCustomer);
    }

    @Transactional
    @Override
    public Order saveOrder(Order order) {
        Order newOrder = new Order();

        newOrder.setOrdnum(order.getOrdnum());
        newOrder.setOrdamount(order.getOrdamount());
        newOrder.setAdvanceamount(order.getAdvanceamount());
        newOrder.setOrderdescription(order.getOrderdescription());
        newOrder.setCustomer(order.getCustomer());

        return orderRepo.save(newOrder);
    }

    @Transactional
    @Override
    public Customer updateCustomer(Customer customer, long custcode) {
        Customer currentCustomer = getCustomerById(custcode);

        if (customer.getAgent() != null){
            currentCustomer.setAgent(customer.getAgent());
        }

        if (customer.getCustname() != null){
            currentCustomer.setCustname(customer.getCustname());
        }

        if (customer.getCustcity() != null){
            currentCustomer.setCustcity(customer.getCustcity());
        }

        if (customer.getWorkingarea() != null){
            currentCustomer.setWorkingarea(customer.getWorkingarea());
        }

        if (customer.getCustcountry() != null){
            currentCustomer.setCustcountry(customer.getCustcountry());
        }

        if (customer.getGrade() != null){
            currentCustomer.setGrade(customer.getGrade());
        }

        if (customer.hasopeningamtValue){
            currentCustomer.setOpeningamt(customer.getOpeningamt());
        }

        if (customer.hasReceiveamtValue){
            currentCustomer.setReceiveamt(customer.getReceiveamt());
        }

        if (customer.hasPaymentamtValue){
            currentCustomer.setPaymentamt(customer.getPaymentamt());
        }

        if (customer.hasOutstandingamtValue){
            currentCustomer.setOutstandingamt(customer.getOutstandingamt());
        }

        if (customer.getPhone() != null){
            currentCustomer.setPhone(customer.getPhone());
        }

        if (customer.getOrders() != null){
            for (Order o : customer.getOrders()){
                Order newOrder = orderRepo.getByOrdnum(o.getOrdnum());
                currentCustomer.addOrder(newOrder);
            }
        }

        if (customer.getAgent() != null){
            currentCustomer.setAgent(customer.getAgent());
        }

        return customerRepo.save(currentCustomer);
    }

    @Transactional
    @Override
    public void deleteCustomer(long custcode) {
        if(getCustomerById(custcode) != null){
            customerRepo.deleteCustomerByCustcode(custcode);
        }
    }

    @Transactional
    @Override
    public Order updateOrder(Order order, long ordnum) {
        Order currentOrder = getOrderById(ordnum);

        if (order.hasOrdAmountValue){
            currentOrder.setOrdamount(order.getOrdamount());
        }

        if (order.hasAdvanceAmtValue){
            currentOrder.setAdvanceamount(order.getAdvanceamount());
        }

        if (order.getOrderdescription() != null){
            currentOrder.setOrderdescription(order.getOrderdescription());
        }

        if (order.getCustomer() != null){
            currentOrder.setCustomer(order.getCustomer());
        }

        return orderRepo.save(currentOrder);
    }

    @Transactional
    @Override
    public void deleteOrder(long ordnum) {
        if (getOrderById(ordnum) != null){
            orderRepo.deleteOrderByOrdnum(ordnum);
        }
    }
}
