package com.gildedrose

import org.junit.Test

class GildedRoseTest {

    @Test
    void "foo"() {
        def items = [ new Item("foo", 3, 6),
                      new Item("Aged Brie", -1, 30)
        ] as Item[]
        def app = new GildedRose(items)
        app.updateQuality()
        //assert "fixme" == app.items[0].name
        println "printout is ${app.items}"
    }

}
