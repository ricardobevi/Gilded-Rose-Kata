package com.gildedrose;

import com.gildedrose.items.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GildedRose {


    private static final Map<String, ItemFactory> itemMap;
    static {
        itemMap = new HashMap<>();
        itemMap.put("Sword of Burning Fire"                     , new RegularFactory());
        itemMap.put("Vest of Hermes"                            , new RegularFactory());
        itemMap.put("Aged Brie"                                 , new GoodAgingFactory());
        itemMap.put("Backstage passes to a TAFKAL80ETC concert" , new DemandedFactory());
        itemMap.put("Sulfuras, Hand of Ragnaros"                , new StaticFactory());
    }


    private List<IItem> items;

    public GildedRose(Item[] items) {

        List<IItem> classifiedItems = new ArrayList<>();

        for (Item item: items) {
            IItem classifiedItem = itemMap.get(item.name).make(item);
            classifiedItems.add(classifiedItem);
        }

        this.items = classifiedItems;
    }

    public void updateQuality() {
        for (IItem item : items)
            item.updateQuality();
    }


    @Override
    public String toString() {
        String str = "";
        for (IItem i : this.items) {
            str += i.toString();
            str += "\n";
        }
        return str;
    }
}