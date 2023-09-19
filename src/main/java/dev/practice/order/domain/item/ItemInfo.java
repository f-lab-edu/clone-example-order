package dev.practice.order.domain.item;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ItemInfo {
    private final String itemToken;
    private final Long partnerId;
    private final String itemName;
    private final Long itemPrice;
    private final Item.Status status;
    private final List<ItemOptionGroupInfo> itemOptionGroupList;

    public ItemInfo(Item item, List<ItemOptionGroupInfo> itemOptionGroupInfoList) {
        this.itemToken = item.getItemToken();
        this.partnerId = item.getPartnerId();
        this.itemName = item.getItemName();
        this.itemPrice = item.getItemPrice();
        this.status = item.getStatus();
        this.itemOptionGroupList = itemOptionGroupInfoList;
    }
}
