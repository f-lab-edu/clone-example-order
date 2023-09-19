package dev.practice.order.domain.item;

import dev.practice.order.domain.partner.PartnerReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final PartnerReader partnerReader;
    private final ItemStore itemStore;
    private final ItemReader itemReader;
    private final ItemOptionSeriesFactory itemOptionSeriesFactory;

    @Override
    public String registerItem(ItemCommand command, String partnerToken) {
        var partner = partnerReader.getPartner(partnerToken);
        var initItem = Item.builder()
                .partnerId(partner.getId())
                .itemName(command.getItemName())
                .itemPrice(command.getItemPrice())
                .build();
        var item = itemStore.store(initItem);
        itemOptionSeriesFactory.store(command, item);
        return item.getItemToken();
    }

    @Override
    public void changePrepare(String itemToken) {
        var item = itemReader.getItemBy(itemToken);

        item.changePrepare();
    }

    @Override
    public void changeOnSales(String itemToken) {
        var item = itemReader.getItemBy(itemToken);

        item.changeOnSales();
    }

    @Override
    public void endOfSales(String itemToken) {
        var item = itemReader.getItemBy(itemToken);

        item.endOfSales();
    }

    @Override
    public ItemInfo retriveItemInfo(String itemToken) {
        var item = itemReader.getItemBy(itemToken);
        var itemOptionGroupInfoList = itemReader.getItemOptionSeries(item);
        return new ItemInfo(item, itemOptionGroupInfoList);
    }
}
