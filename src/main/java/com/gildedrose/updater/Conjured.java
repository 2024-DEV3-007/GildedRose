package com.gildedrose.updater;

import com.gildedrose.Item;
import static com.gildedrose.validation.ItemValidator.*;
public class Conjured implements ItemUpdater{

    @Override
    public void update (Item item) {
        int decrementValue = (item.sellIn > 0) ? 2 :4;
        decrementQuality(item,decrementValue);
        updateSellInDays(item);
    }
}
