package dev.practice.order.infrastructure.item;

import dev.practice.order.domain.item.ItemOptionGroup;
import dev.practice.order.domain.item.ItemOptionGroupStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ItemOptionGroupStoreImpl implements ItemOptionGroupStore {
    private final ItemOptionGroupRepository itemOptionGroupRepository;

    @Override
    public ItemOptionGroup store(ItemOptionGroup itemOptionGroup) {
        return itemOptionGroupRepository.save(itemOptionGroup);
    }
}
