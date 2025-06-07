package com.gildedrose.updater;

import com.gildedrose.Item;
import static com.gildedrose.validation.ItemValidator.*;

public class DefaultItem implements ItemUpdater{

    @Override
    public void update (Item item) {
        int decrementValue = (item.sellIn > 0) ? 1 : 2;
        decrementQuality(item,decrementValue);
        updateSellInDays(item);
    }

    private void decrementQuality (Item item, int amount) {
        item.quality = Math.max (item.quality - amount, 0);
    }
}
