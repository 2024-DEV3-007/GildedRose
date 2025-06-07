package com.gildedrose.updater;

import com.gildedrose.Item;
import static com.gildedrose.validation.ItemValidator.*;

public class DefaultItem implements ItemUpdater{

    @Override
    public void update (Item item) {
        int decrement = (item.sellIn > 0) ? 1 : 2;
        item.quality -= decrement;
        updateSellInDays(item);
    }
}
