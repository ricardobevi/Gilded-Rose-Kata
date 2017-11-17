package com.gildedrose.items;

import com.gildedrose.Item;

public class DemandedFactory implements ItemFactory {
    public IItem make(Item item) {
        return new DemandedItem(item);
    }
}
