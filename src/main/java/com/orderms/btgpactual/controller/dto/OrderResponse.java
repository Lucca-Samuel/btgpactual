package com.orderms.btgpactual.controller.dto;

import java.math.BigDecimal;

public record OrderResponse(Long orderId, Long custumerId, BigDecimal total) {
}
