package com.gildedrose.updater;

import com.gildedrose.Item;
import static com.gildedrose.constant.Constants.*;
import static com.gildedrose.validation.ItemValidator.*;

public class DefaultItem implements ItemUpdater{

    @Override
    public void update (Item item) {
        decrementQuality (item, BASE_QUALITY_DECREMENT);
        updateSellInDays (item);
        updateQualityForExpiredItem (item);;
    }

    private static void updateQualityForExpiredItem (Item item) {
        if (isExpired (item))
            decrementQuality (item, BASE_QUALITY_DECREMENT);
    }
}
