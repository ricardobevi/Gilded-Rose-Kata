package com.gildedrose;

public class DemandedItem extends AbstractItem implements IItem {

    private int passSellFirst;
    private int passSellSecond;

    DemandedItem(String name, int sellIn, int quality){
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;

        this.passSellFirst = 10;
        this.passSellSecond = 5;
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
