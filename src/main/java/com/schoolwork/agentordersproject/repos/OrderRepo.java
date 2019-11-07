package com.schoolwork.agentordersproject.repos;

import com.schoolwork.agentordersproject.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order, Long> {
    Order getByOrdnum(long ordnum);
}
