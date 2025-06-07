package com.gildedrose.updater;

import com.gildedrose.Item;
import com.gildedrose.ItemType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackStagePassesTest {

    private BackStagePasses backStagePasses;

    @BeforeEach
    void setUp () {
        backStagePasses = new BackStagePasses ();
    }

    @Test
    @DisplayName ("BackStage Passes : SellIn value reduces by one")
    void updateSellInDaysForBackStagePasses () {

        Item item = new Item (ItemType.BACK_STAGE_PASSES.getItemName (), 1, 1);

        backStagePasses.update (item);

        assertEquals (0, item.sellIn);
    }
}
