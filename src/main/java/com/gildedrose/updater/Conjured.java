package com.gildedrose.updater;

import com.gildedrose.Item;
import static com.gildedrose.validation.ItemValidator.*;
public class Conjured implements ItemUpdater{

    @Override
    public void update (Item item) {
        if (item.sellIn > 0)
            item.quality-=2;
        else
            item.quality-=4;
        updateSellInDays(item);
    }
}
