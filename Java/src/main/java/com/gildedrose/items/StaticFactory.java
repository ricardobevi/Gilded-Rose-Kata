package com.gildedrose.items;

import com.gildedrose.Item;

public class StaticFactory implements ItemFactory {
    public IItem make(Item item) {
        return new StaticItem(item);
    }
}
