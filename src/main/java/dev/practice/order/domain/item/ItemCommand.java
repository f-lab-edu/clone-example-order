package dev.practice.order.domain.item;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ItemCommand {
    private Long partnerId;
    private String itemName;
    private Long itemPrice;
}
