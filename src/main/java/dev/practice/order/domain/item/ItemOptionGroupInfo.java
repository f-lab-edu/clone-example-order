package dev.practice.order.domain.item;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ItemOptionGroupInfo {
    private final Integer ordering;
    private final String itemOptionGroupName;
    private final List<ItemOptionInfo> itemOptionList;
}
