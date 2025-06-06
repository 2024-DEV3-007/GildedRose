## Gilded Rose

The Gilded Rose is a small inn with a system that updates the `sellIn` and `quality` values of its inventory items daily. The following rules describe how the system must behave:

- **All items** have a `sellIn` value which denotes the number of days we have to sell the item.
- **All items** have a `quality` value which denotes how valuable the item is.
- At the end of each day, the system updates both values for every item.

### General Rules

- At the end of each day, decrease the `sellIn` value by 1.
- At the end of each day, decrease the `quality` value by 1 for normal items.
- Once the `sellIn` value is less than 0, `quality` degrades twice as fast (i.e., decreases by 2).
- The `quality` of an item is never negative.
- The `quality` of an item is never more than 50.

### Special Items

- **Aged Brie**
    - Increases in `quality` the older it gets.

- **Sulfuras** (Legendary Item)
    - `quality` and `sellIn` never change.

- **Backstage passes**
    - Increases in `quality` as its `sellIn` value approaches:
        - `quality` increases by 2 when there are 10 days or less.
        - `quality` increases by 3 when there are 5 days or less.
        - `quality` drops to 0 after the concert.

- **Conjured Items**
    - Degrade in `quality` twice as fast as normal items.

---


