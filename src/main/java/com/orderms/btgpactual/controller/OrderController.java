package com.orderms.btgpactual.controller;

import com.orderms.btgpactual.controller.dto.ApiResponse;
import com.orderms.btgpactual.controller.dto.OrderResponse;
import com.orderms.btgpactual.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderController {
    private final OrderService service;

    @GetMapping("/custumers/{custumerId}/orders")
    public ResponseEntity<ApiResponse<OrderResponse>> listOrders(@RequestParam(name = "page", defaultValue = "0")Integer page,
                                                                 @RequestParam(name = "pageSize", defaultValue = "10")Integer pageSize){
        return ResponseEntity.ok(null);
    }
}
