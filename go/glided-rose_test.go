package main

import (
	"testing"
	"github.com/stretchr/testify/assert"
	"os"
	"fmt"
)

var items []*Item

func TestMain(m *testing.M) {
	items = []*Item{
		{"Sword of Burning Fire", 10, 26},
		{"Aged Brie", 10, 0},
		{"Vest of Hermes", 5, 7},
		{"Backstage passes to a TAFKAL80ETC concert", 10, 24},
		{"Sulfuras, Hand of Ragnaros", 0, 80},
		{"Sulfuras, Hand of Ragnaros", -1, 80},
	}

	os.Exit(m.Run())
}

func Test_Update_Quality_For_1_Day(t *testing.T) {
	its := items

	GildedRose(its)

	assert.Equal(t, "Sword of Burning Fire, 9, 25\nAged Brie, 9, 1\nVest of Hermes, 4, 6\nBackstage passes to a TAFKAL80ETC concert, 9, 26\nSulfuras, Hand of Ragnaros, 0, 80\nSulfuras, Hand of Ragnaros, -1, 80\n",
		printItems(its))
}

func Test_Update_Quality_For_Until_Items_Expire(t *testing.T) {
	its := items

	for cant := 0; cant < 10 ; cant++ {
		GildedRose(its)
	}

	assert.Equal(t, "Sword of Burning Fire, 0, 16\nAged Brie, 0, 10\nVest of Hermes, -5, 0\nBackstage passes to a TAFKAL80ETC concert, 0, 49\nSulfuras, Hand of Ragnaros, 0, 80\nSulfuras, Hand of Ragnaros, -1, 80\n",
		printItems(its))
}
//
//func TestGildedRose_Conjured(t *testing.T) {
//	item := &Item{
//		name: "Conjured",
//		quality: 10,
//		sellIn: 3,
//	}
//
//	items := []*Item{item}
//
//	GildedRose(items)
//
//	assert.Equal(t, "Conjured", item.name)
//	assert.Equal(t, 8, item.quality)
//	assert.Equal(t, 2, item.sellIn)
//}
//
//func TestGildedRose_Conjured_Negative(t *testing.T) {
//	item := &Item{
//		name: "Conjured",
//		quality: 1,
//		sellIn: 3,
//	}
//
//	items := []*Item{item}
//
//	GildedRose(items)
//
//	assert.Equal(t, "Conjured", item.name)
//	assert.Equal(t, 0, item.quality)
//	assert.Equal(t, 2, item.sellIn)
//}

func printItems(its []*Item) string {
	res := ""

	for _, i := range its {
		res += printItem(i)
	}

	return res
}

func printItem(i *Item) string {
	return fmt.Sprintf("%v, %v, %v\n", i.name , i.sellIn, i.quality)
}