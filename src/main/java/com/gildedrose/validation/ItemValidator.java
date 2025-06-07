package com.gildedrose.validation;

import com.gildedrose.Item;

import static com.gildedrose.constant.Constants.*;

public class ItemValidator {

    public static void updateSellInDays (Item item) {
        item.sellIn--;
    }

    public static void incrementQuality (Item item, int amount) {
        item.quality = Math.min (item.quality + amount, MAX_QUALITY);
    }

    public static boolean isExpired (Item item) {
        return item.sellIn < 0;
    }

    public static void decrementQuality (Item item, int amount) {
        item.quality = Math.max (item.quality - amount, MIN_QUALITY);
    }

    public static void setQualityToMinimum (Item item) {
        item.quality = MIN_QUALITY;
    }
}
