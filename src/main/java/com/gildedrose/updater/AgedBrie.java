package com.gildedrose.updater;

import com.gildedrose.Item;
import static com.gildedrose.constant.Constants.*;
import static com.gildedrose.validation.ItemValidator.*;

public class AgedBrie implements ItemUpdater {

    @Override
    public void update (Item item) {
        incrementQuality (item, BASE_QUALITY_INCREMENT);
        updateSellInDays (item);
        updateQualityForExpiredItem (item);
    }

    private void updateQualityForExpiredItem (Item item) {
        if (isExpired (item))
            incrementQuality (item, BASE_QUALITY_INCREMENT);
    }
}
