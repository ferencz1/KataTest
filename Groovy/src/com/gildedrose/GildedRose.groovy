package com.gildedrose

class GildedRose {
    Item[] items

    GildedRose(Item[] items) {
        this.items = items
    }

    void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            String name = items[i].name.toLowerCase()
            int min_qual = 0
            int max_qual = 50
            if (!name.equals("aged brie") && !name.contains("backstage passes") && !name.contains("sulfuras")) {
                if (items[i].quality > min_qual) {
                    items[i].quality = items[i].quality - 1

                    if(name.contains("conjured") && items[i].quality > min_qual) {
                        items[i].quality = items[i].quality - 1
                    }
                }
            }
            else {
                if (name.contains("backstage passes") && items[i].sellIn <= 0) {
                    items[i].quality = 0
                }
                else {
                    if (items[i].quality < max_qual) {
                        /**
                         * increase quality for "backstage" and "others"
                         */
                        items[i].quality = items[i].quality + 1

                        if (name.contains("backstage passes")) {
                            /**
                             * increase "backstage" for tickets in 10 days
                             */
                            if (items[i].sellIn < 11) {
                                if (items[i].quality < max_qual) {
                                    items[i].quality = items[i].quality + 1
                                }
                            }
                            /**
                             * increase "backstage" for tickets in 5 days
                             */
                            if (items[i].sellIn < 6) {
                                if (items[i].quality < max_qual) {
                                    items[i].quality = items[i].quality + 1
                                }
                            }
                        }
                    }
                }
            }
            if (items[i].sellIn < 0) {
                /**
                 * if it's "conjured", decrease by one
                 */
                if (name.contains("conjured") && items[i].quality > 0) {
                    items[i].quality = items[i].quality - 1
                }
                /**
                 * if it's "conjured" or "other", decrease by one
                 */
                if (!name.equals("aged brie") && !name.contains("backstage passes") && !name.contains("sulfuras")
                        && items[i].quality > 0) {
                    items[i].quality = items[i].quality - 1
                }
            }
            /**
             * decrease sellIn for all, except "sulfuras"
             */
            if (!name.contains("sulfuras")) {
                items[i].sellIn = items[i].sellIn - 1
            }
        }
    }
}
