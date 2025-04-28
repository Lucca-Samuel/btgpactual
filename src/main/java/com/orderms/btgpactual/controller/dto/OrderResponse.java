package com.orderms.btgpactual.controller.dto;

import com.orderms.btgpactual.entity.OrderEntity;

import java.math.BigDecimal;

public record OrderResponse(Long orderId, Long custumerId, BigDecimal total) {

    public static OrderResponse fromEntity(OrderEntity entity){
        return new OrderResponse(entity.getOrderID(), entity.getCustumerId(), entity.getTotal());
    }
}
