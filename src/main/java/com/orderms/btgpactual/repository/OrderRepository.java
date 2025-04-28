package com.orderms.btgpactual.repository;

import com.orderms.btgpactual.controller.dto.OrderResponse;
import com.orderms.btgpactual.entity.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEntity, Long> {

    Page<OrderEntity> findAllByCustumerId(Long custumerId, PageRequest pageRequest);
}
