package com.gildedrose.items;

import com.gildedrose.Item;

class DemandedItem extends AbstractItem implements IItem {

    private int passSellFirst = 10;
    private int passSellSecond = 5;


    DemandedItem(Item item){
        super(item);
    }

    DemandedItem(String name, int sellIn, int quality){
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality() {
        updateQualityOfDemandedItem();
        decreaseSellIn();

        if(this.hasExpired())
            this.quality = 0;
    }

    private void updateQualityOfDemandedItem() {

        increaseQuality();

        if (this.sellIn <= passSellFirst)
            increaseQuality();

        if (this.sellIn <= passSellSecond)
            increaseQuality();

    }

}
