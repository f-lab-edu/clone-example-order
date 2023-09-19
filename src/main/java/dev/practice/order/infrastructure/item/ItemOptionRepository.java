package dev.practice.order.infrastructure.item;

import dev.practice.order.domain.item.ItemOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemOptionRepository extends JpaRepository<ItemOption, Long> {
}
