package dev.practice.order.domain.order;

public interface PaymentValidator {
    void validate(Order order, OrderCommand.PaymentRequest paymentRequest);
}
