package com.gildedrose;

class GildedRose {

    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : this.items)
            this.updateQualityForOneItem(item);
    }

    private void updateQualityForOneItem(Item item) {
        this.updateQuality(item);
        this.updateSellIn(item);

        if (this.hasExpired(item))
            this.updateExpired(item);
    }

    private boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }

    private void updateExpired(Item item) {
        if (item.name.equals("Aged Brie")) {
            incrementQuality(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
        } else {
            decrementQuality(item);
        }
    }

    private void updateSellIn(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn--;
    }

    private void updateQuality(Item item) {
        if (item.name.equals("Aged Brie")) {
            incrementQuality(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            incrementQuality(item);

            if (item.sellIn < 11) {
                incrementQuality(item);
            }

            if (item.sellIn < 6) {
                incrementQuality(item);
            }
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
        } else {
            decrementQuality(item);
        }
    }

    private void decrementQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (Item i : this.items) {
            str += i.toString();
            str += "\n";
        }
        return str;
    }
}