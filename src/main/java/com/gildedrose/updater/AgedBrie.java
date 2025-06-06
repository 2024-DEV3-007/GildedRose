package com.gildedrose.updater;

import com.gildedrose.Item;

public class AgedBrie implements ItemUpdater {

    @Override
    public void update (Item item) {
        incrementQuality (item, 1);
        updateSellInDays (item);
        updateQualityForExpiredItem (item);
    }

    private void incrementQuality (Item item, int amount) {
        item.quality = Math.min (item.quality + amount, 50);
    }

    private void updateSellInDays (Item item) {
        item.sellIn--;
    }

    private void updateQualityForExpiredItem (Item item) {
        if (isExpired (item))
            incrementQuality (item, 1);
    }

    private boolean isExpired (Item item) {
        return item.sellIn < 0;
    }
}
