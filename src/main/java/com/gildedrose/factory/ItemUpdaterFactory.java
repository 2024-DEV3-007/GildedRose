package com.gildedrose.factory;

import com.gildedrose.ItemType;
import com.gildedrose.updater.AgedBrie;
import com.gildedrose.updater.ItemUpdater;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ItemUpdaterFactory {

    private static final Map<String, Supplier<ItemUpdater>> ITEM_SUPPLIER = createItemsMap ();

    private static Map<String, Supplier<ItemUpdater>> createItemsMap () {
        Map<String, Supplier<ItemUpdater>> map = new HashMap<> ();
        map.put (ItemType.AGED_BRIE.getItemName (), AgedBrie::new);
        return map;
    }

    public static ItemUpdater getItems (String itemType) {
        return ITEM_SUPPLIER.get (itemType).get ();
    }
}
