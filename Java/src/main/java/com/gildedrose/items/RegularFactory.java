package com.gildedrose.items;

import com.gildedrose.Item;

public class RegularFactory implements ItemFactory {

    public IItem make(Item item){
        return new RegularItem(item);
    }

}
