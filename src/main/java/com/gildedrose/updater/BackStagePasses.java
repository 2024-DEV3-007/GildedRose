package com.gildedrose.updater;

import com.gildedrose.Item;
import static com.gildedrose.validation.ItemValidator.*;

public class BackStagePasses implements ItemUpdater{

    @Override
    public void update (Item item) {
        if (item.sellIn >0)
            incrementQuality(item,1);
        updateSellInDays (item);
    }
}
