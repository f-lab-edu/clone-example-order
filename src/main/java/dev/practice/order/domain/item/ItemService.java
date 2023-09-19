package dev.practice.order.domain.item;

public interface ItemService {
    String registerItem(ItemCommand command, String partnerToken);
    void changePrepare(String itemToken);
    void changeOnSales(String itemToken);
    void endOfSales(String itemToken);
    ItemInfo retriveItemInfo(String itemToken);
}
