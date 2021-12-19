package com.hg;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ForgettingMapTest {

    @Test
    public void itemsCanBeAddedAndRetrieved() {

        ForgettingMap<String, String> forgettingMap = new ForgettingMap<>(1);
        forgettingMap.add("key", "value");

        assertEquals("value", forgettingMap.find("key"));
    }

    @Test
    public void findReturnsNullIfKeyDoesNotExist() {
        ForgettingMap<String, String> forgettingMap = new ForgettingMap<>(1);
        assertNull(forgettingMap.find("key"));
    }

    @Test
    public void addRemovesFirstItem() {
        ForgettingMap<String, String> forgettingMap = new ForgettingMap<>(1);
        forgettingMap.add("key1", "value1");
        forgettingMap.add("key2", "value2");

        assertNull(forgettingMap.find("key1"));
        assertEquals(forgettingMap.find("key2"), "value2");
    }

    @Test
    public void leastUsedItemIsRemoved() {
        ForgettingMap<String, String> forgettingMap = new ForgettingMap<>(3);
        forgettingMap.add("key1", "value1");
        forgettingMap.add("key2", "value2");
        forgettingMap.add("key3", "value3");

        forgettingMap.find("key1");
        forgettingMap.find("key1");
        forgettingMap.find("key2");

        forgettingMap.add("key4", "value4");

        assertEquals(forgettingMap.find("key1"), "value1");
        assertEquals(forgettingMap.find("key2"), "value2");
        assertNull(forgettingMap.find("key3"));
        assertEquals(forgettingMap.find("key4"), "value4");
    }
}
