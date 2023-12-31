package dev.practice.order.infrastructure.order;

import dev.practice.order.domain.order.OrderItemOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemOptionRepository extends JpaRepository<OrderItemOption, Long> {
}
