package com.schoolwork.agentordersproject.repos;

import com.schoolwork.agentordersproject.model.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepo extends CrudRepository<Payment, Long> {
}
