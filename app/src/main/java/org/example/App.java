package org.example;

import java.util.ArrayList;

/**
 * Main application for searching a "golden fuzzy" in the list of fuzzies.
 * Demonstrates both linear and binary search algorithms on sorted and randomized lists
 * of Fuzzy objects.
 *
 * About the output, it shows how binary search requires a sorted list to function correctly
 *
 * @author Zhengjia Liu
 */
public class App {

    /**
     * Performs a linear search for the "gold" fuzzy in the provided list.
     *
     * @param fuzzies The ArrayList of Fuzzy objects to search through.
     * @return The index of the golden fuzzy, or -1 if not found.
     */
    public static int linearSearch(ArrayList<Fuzzy> fuzzies) {
        for (int i = 0; i < fuzzies.size(); i++) {
            if ("gold".equals(fuzzies.get(i).color)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Performs a binary search for the "gold" fuzzy in the provided list.
     *
     * @param fuzzies The ArrayList of Fuzzy objects to search through (must be sorted).
     * @return The index of the golden fuzzy, or -1 if not found.
     */
    public static int binarySearch(ArrayList<Fuzzy> fuzzies) {
        int left = 0;
        int right = fuzzies.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            String color = fuzzies.get(mid).color;
            int cmp = color.compareTo("gold");
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Utility method to print the colors of the first n fuzzies in a list.
     *
     * @param fuzzies The list to print from.
     * @param n The number of items to print.
     */
    public static void printFirstFuzzies(ArrayList<Fuzzy> fuzzies, int n) {
        System.out.print("[");
        for (int i = 0; i < n && i < fuzzies.size(); i++) {
            System.out.print(fuzzies.get(i).color);
            if (i < n-1 && i < fuzzies.size()-1) System.out.print(", ");
        }
        System.out.println("...]");
    }

    /**
     * Entry point of the application.
     * Generates a sorted and a randomized list of fuzzies, and then
     * performs both linear and binary search for the golden fuzzy
     * in each list. And then the result printed.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        FuzzyListGenerator generator = new FuzzyListGenerator();

        // Generate a sorted list
        ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();

        // Generate a randomized list
        ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();

        // Show that the list is actually sorted by color
        System.out.println("First 20 fuzzies in sorted list:");
        printFirstFuzzies(sortedFuzzies, 20);

        // Linear and binary search on sorted list
        int idx1 = linearSearch(sortedFuzzies);
        System.out.println("Linear search on sorted list: " + idx1);

        int idx2 = binarySearch(sortedFuzzies);
        System.out.println("Binary search on sorted list: " + idx2);

        // Linear and binary search on random list
        int idx3 = linearSearch(randomFuzzies);
        System.out.println("Linear search on random list: " + idx3);

        int idx4 = binarySearch(randomFuzzies);
        System.out.println("Binary search on random list: " + idx4);
    }
}
