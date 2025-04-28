package com.orderms.btgpactual.controller;

import com.orderms.btgpactual.controller.dto.ApiResponse;
import com.orderms.btgpactual.controller.dto.OrderResponse;
import com.orderms.btgpactual.controller.dto.PaginationResponse;
import com.orderms.btgpactual.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class OrderController {
    private final OrderService service;

    @GetMapping("/custumers/{custumerId}/orders")
    public ResponseEntity<ApiResponse<OrderResponse>> listOrders(@PathVariable("custumerId") Long custumerId,
                                                                 @RequestParam(name = "page", defaultValue = "0")Integer page,
                                                                 @RequestParam(name = "pageSize", defaultValue = "10")Integer pageSize){

        var pageResponse = service.findAllByCustumerId(custumerId, PageRequest.of(page, pageSize));

        return ResponseEntity.ok(new ApiResponse<>(
                pageResponse.getContent(),
                PaginationResponse.fromPage(pageResponse)
        ));
    }
}
