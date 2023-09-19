package dev.practice.order.domain.item;

import java.util.List;

public interface ItemOptionSeriesFactory {
    List<ItemOptionGroup> store(ItemCommand command, Item item);
}
