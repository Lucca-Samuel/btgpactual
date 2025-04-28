package com.orderms.btgpactual.repository;

import com.orderms.btgpactual.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEntity, Long> {
}
