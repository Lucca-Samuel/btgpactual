package com.orderms.btgpactual.services;

import com.orderms.btgpactual.dto.OrderCreatedEvent;
import com.orderms.btgpactual.entity.OrderEntity;
import com.orderms.btgpactual.entity.OrderItem;
import com.orderms.btgpactual.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public void save(OrderCreatedEvent event){
        var entity = new OrderEntity();
        entity.setOrderID(event.codigoPedido());
        entity.setCustomerId(event.codigoCliente());

        entity.setItems(getOrderItens(event));
        entity.setTotal(getTotal(event));

        repository.save(entity);
    }

    private BigDecimal getTotal(OrderCreatedEvent event) {
        return event.itens().stream()
                .map(i -> i.price().multiply(BigDecimal.valueOf(i.quantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private static List<OrderItem> getOrderItens(OrderCreatedEvent event) {
        return event.itens().stream().map(i -> new OrderItem(i.product(), i.quantity(), i.price()))
                .toList();
    }
}
