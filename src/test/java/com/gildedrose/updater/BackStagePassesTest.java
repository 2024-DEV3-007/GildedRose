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

    @Test
    @DisplayName("BackStage Passes : Quality increases by 1 each day before the sellIn date")
    void updateQualityBeforeSellInDayForBackStagePasses () {

        Item item = new Item (ItemType.BACK_STAGE_PASSES.getItemName (), 15, 10);

        backStagePasses.update (item);

        assertEquals (11, item.quality);
    }

    @Test
    @DisplayName("Backstage Pass : Maximum quality  is 50")
    void qualityNeverExceedsFiftyForBackStagePass () {

        Item item = new Item (ItemType.BACK_STAGE_PASSES.getItemName (), 6, 50);

        backStagePasses.update (item);

        assertEquals (50, item.quality);
    }

    @Test
    @DisplayName("Backstage Pass : Quality increases by 2 when sellIn is between 5 and 10")
    void updateQualityWhenSellInBetweenFiveAndTen () {

        Item item = new Item (ItemType.BACK_STAGE_PASSES.getItemName (), 8, 10);

        backStagePasses.update (item);

        assertEquals (12, item.quality);
    }

    @Test
    @DisplayName("Backstage Pass : Quality increases by 3 when sellIn less than 5")
    void updateQualityWhenSellInLessThanFive () {

        Item item = new Item (ItemType.BACK_STAGE_PASSES.getItemName (), 4, 12);

        backStagePasses.update (item);

        assertEquals (15, item.quality);
    }

    @Test
    @DisplayName("Backstage Pass : Quality drops to 0 when sellIn expires")
    void updateQualityWhenSellInExpires () {

        Item item = new Item (ItemType.BACK_STAGE_PASSES.getItemName (), 0, 12);

        backStagePasses.update (item);

        assertEquals (0, item.quality);
    }
}
