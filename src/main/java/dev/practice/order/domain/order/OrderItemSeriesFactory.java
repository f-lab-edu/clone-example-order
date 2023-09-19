package dev.practice.order.domain.order;

import java.util.List;

public interface OrderItemSeriesFactory {
    List<OrderItem> store(OrderCommand.RegisterOrder request, Order order);
}
