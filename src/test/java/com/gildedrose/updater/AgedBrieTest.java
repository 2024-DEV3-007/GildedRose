package com.gildedrose.updater;

import com.gildedrose.Item;
import com.gildedrose.ItemType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {

    private AgedBrie agedBrie;

    @BeforeEach
    void setUp () {
        agedBrie = new AgedBrie ();
    }

    @Test
    @DisplayName("Aged Brie sellIn value reduces by one")
    void updateSellInDaysForAgedBrie () {

        Item item = new Item (ItemType.AGED_BRIE.getItemName (), 1, 1);

        agedBrie.update (item);

        assertEquals (0, item.sellIn);
    }

    @Test
    @DisplayName("Quality of Aged Brie increases by 1 each day before the sellIn date")
    void updateQualityBeforeSellInDayForAgedBrie () {

        Item item = new Item (ItemType.AGED_BRIE.getItemName (), 5, 10);

        agedBrie.update (item);

        assertEquals (11, item.quality);
    }

    @Test
    @DisplayName("Quality of Aged Brie increases by 2 each day after the sellIn date")
    void updateQualityAfterSellInDayForAgedBrie () {

        Item item = new Item (ItemType.AGED_BRIE.getItemName (), 0, 10);

        agedBrie.update (item);

        assertEquals (12, item.quality);
    }

    @Test
    @DisplayName("Maximum quality of Aged Brie is 50")
    void qualityNeverExceedsFiftyForAgedBrie () {

        Item item = new Item (ItemType.AGED_BRIE.getItemName (), 2, 50);

        agedBrie.update (item);

        assertEquals (50, item.quality);
    }
}
