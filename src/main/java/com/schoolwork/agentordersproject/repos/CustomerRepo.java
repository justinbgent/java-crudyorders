package com.schoolwork.agentordersproject.repos;

import com.schoolwork.agentordersproject.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CustomerRepo extends CrudRepository<Customer, Long> {
    ArrayList<Customer> findByCustnameContainingIgnoringCase(String likename);

    ArrayList<Customer> getAllBy();

    Customer getByCustcode(long custcode);
}
