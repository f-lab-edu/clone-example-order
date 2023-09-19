package dev.practice.order.domain.item;

public interface ItemService {
    String registerItem(ItemCommand.RegisterItemRequest request, String partnerToken);
    void changePrepare(String itemToken);
    void changeOnSales(String itemToken);
    void endOfSales(String itemToken);
    ItemInfo.Main retriveItemInfo(String itemToken);
}
