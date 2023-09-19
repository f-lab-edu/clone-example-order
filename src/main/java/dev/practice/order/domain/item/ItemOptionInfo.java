package dev.practice.order.domain.item;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItemOptionInfo {
    private final Integer ordering;
    private final String itemOptionName;
    private final Long itemOptionPrice;
}
