package com.gildedrose.factory;

import com.gildedrose.ItemType;
import com.gildedrose.updater.AgedBrie;
import com.gildedrose.updater.BackStagePasses;
import com.gildedrose.updater.DefaultItem;
import com.gildedrose.updater.ItemUpdater;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemUpdaterFactoryTest {

    @Test
    @DisplayName ("Retrieving Aged Brie item")
    void getItemAgedBrie() {

        ItemUpdater agedBrie = ItemUpdaterFactory.getItems (ItemType.AGED_BRIE.getItemName ());

        assertTrue (agedBrie instanceof AgedBrie);
    }

    @Test
    @DisplayName("Retrieving Default item")
    void getDefaultItem() {

        ItemUpdater defaultItem = ItemUpdaterFactory.getItems ("Elixir of the Mongoose");

        assertTrue (defaultItem instanceof DefaultItem);
    }

    @Test
    @DisplayName("Retrieving Backstage Passes item")
    void getBackStagePassesItem() {

        ItemUpdater backStagePasses = ItemUpdaterFactory.getItems (ItemType.BACK_STAGE_PASSES.getItemName ());

        assertTrue (backStagePasses instanceof BackStagePasses);
    }
}
