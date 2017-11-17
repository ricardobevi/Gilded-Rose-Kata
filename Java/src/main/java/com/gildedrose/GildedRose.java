package com.gildedrose;

class GildedRose {

    private IItem[] items;

    public GildedRose(IItem[] items) {
        this.items = items;
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