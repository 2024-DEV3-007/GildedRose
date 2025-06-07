package com.gildedrose;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemType {

    AGED_BRIE ("Aged Brie"),
    BACK_STAGE_PASSES ("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS ("Sulfuras, Hand of Ragnaros");

    private final String itemName;
}
