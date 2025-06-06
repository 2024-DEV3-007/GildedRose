package com.gildedrose;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemType {

    AGED_BRIE ("Aged Brie");

    private final String itemName;
}
