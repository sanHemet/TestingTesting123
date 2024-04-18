package com.example.testingtesting123

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    @Test
    fun addAnItem() {
        collection.addItem(Item("Item1"))
        val item = collection.get(0)
        assert(item.name == "Item1")
    }

    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        assert (collection.size() == 2)
    }

    @Test
    fun getItem() {

        val item1 = Item("Item1");
        collection.addItem(item1);
        val gotItem = collection.get(0);

        assert(gotItem.equals(item1)) {"Could not GET item"}

    }

    @Test
    fun removeItem() {

        collection.addItem(Item("Item1"));
        collection.addItem(Item("Item2"));

        val currentSize = collection.size();

        collection.remove(Item("Item1"));

        assert(collection.get(0).equals(Item("Item2")) && collection.size().equals(currentSize-1)) {"Item not removed"}
    }

    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }
}