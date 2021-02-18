package com.schoolwork.agentordersproject.repos;

import com.schoolwork.agentordersproject.model.OrderPayment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface OrderPaymentRepo extends CrudRepository<OrderPayment, Long> {
//    @Query(value = "INSERT INTO orderspayments (ordnum, paymentid) VALUES (:orderid, :paymentid)", nativeQuery = true)
//    void insertPaymentAndOrders(long orderId, long paymentId);
}
