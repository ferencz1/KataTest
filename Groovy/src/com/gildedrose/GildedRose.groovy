package com.gildedrose

class GildedRose {
    Item[] items

    GildedRose(Item[] items) {
        this.items = items
    }

    /*void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1
                    }
                }
            }
        }
    }*/
    void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            String name = items[i].name.toLowerCase()
            if (items[i].quality > 0){
                if (!name.equals("aged brie") && !name.contains("backstage")
                        && !name.contains("conjured") && !name.contains("sulfuras")){
                    items[i].quality = items[i].quality - 1
                }
                else if(name.contains("conjured")){
                    items[i].quality = items[i].quality - 2
                }
            }
            else if(items[i].quality < 50){
                if(name.equals("aged brie")){
                    items[i].quality = items[i].quality + 1
                }
                else if(name.contains("backstage")){
                    if(items[i].sellIn > 10){
                        items[i].quality = items[i].quality + 1
                    }
                    else if(items[i].sellIn <= 10 && items[i].sellIn > 5){
                        items[i].quality = items[i].quality + 2
                    }
                    else if(items[i].sellIn <= 5 && items[i].sellIn >= 0){
                        items[i].quality = items[i].quality + 3
                    }
                    else
                    {
                        items[i].quality = 0
                    }
                }
            }
            if (!name.contains("sulfuras")) {
                items[i].sellIn = items[i].sellIn - 1
            }

        }
    }
}
