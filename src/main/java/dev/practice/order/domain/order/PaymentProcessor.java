package dev.practice.order.domain.order;

public interface PaymentProcessor {
    void pay(Order order, OrderCommand.PaymentRequest request);
}
