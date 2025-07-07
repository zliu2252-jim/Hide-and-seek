package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

/**
 * This part is the JUnit tests for the App's class search methods.
 * Tests both linear and binary search functionality with various input cases.
 */
class AppTest {

    /**
     * Test the linearSearch returns the correct index
     * when the golden fuzzy is present in the list.
     */
    @Test
    void testLinearSearchFindsGold() {
        ArrayList<Fuzzy> list = new ArrayList<>();
        list.add(new Fuzzy("red"));
        list.add(new Fuzzy("blue"));
        list.add(new Fuzzy("gold"));
        assertEquals(2, App.linearSearch(list));
    }

    /**
     * Tests the linear search returns -1 when the golden fuzzy is not present.
     */
    @Test
    void testLinearSearchNotFound() {
        ArrayList<Fuzzy> list = new ArrayList<>();
        list.add(new Fuzzy("red"));
        list.add(new Fuzzy("blue"));
        assertEquals(-1, App.linearSearch(list));
    }

    /**
     * Tests the binary search can find "gold" when the list is sorted by color.
     */
    @Test
    void testBinarySearchFindsGold() {
        ArrayList<Fuzzy> list = new ArrayList<>();
        list.add(new Fuzzy("blue"));
        list.add(new Fuzzy("gold"));
        list.add(new Fuzzy("red"));
        // Must sort before binary search
        list.sort((f1, f2) -> f1.color.compareTo(f2.color));
        int idx = MainApp.binarySearch(list);
        assertNotEquals(-1, idx);
        assertEquals("gold", list.get(idx).color);
    }

    /**
     * Tests the binarySearch returns -1 when "gold" is not in the sorted list.
     */
    @Test
    void testBinarySearchNotFound() {
        ArrayList<Fuzzy> list = new ArrayList<>();
        list.add(new Fuzzy("blue"));
        list.add(new Fuzzy("red"));
        list.sort((f1, f2) -> f1.color.compareTo(f2.color));
        assertEquals(-1, App.binarySearch(list));
    }
}
