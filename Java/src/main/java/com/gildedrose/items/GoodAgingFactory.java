package com.gildedrose.items;

import com.gildedrose.Item;

public class GoodAgingFactory implements ItemFactory {
    public IItem make(Item item) {
        return new GoodAgingItem(item);
    }
}
