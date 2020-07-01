/*
    Binary Search
    1. Sort
    2. Then search

    If high <= low , not found ( nothing in between) - return -1.
    middle = low + (high - low)/2
    Compare array[middle] to key
    if array[middle] compared to key > 0, it is smaller than middle
        search between low and middle;
    if array[middle] compared to key < 0, it is bigger than middle
        search between middle + 1 to high;


    main: Save all input to variable with readAll();
        : Use regex to
    Regex expression : "\\s+" matches one or many whitespace.


*/

import java.util.Arrays;

public class BS {
    public static int search(String key, String[] a) {
        return search(key, a, 0, a.length);
    }

    public static int search(String key, String[] a, int low, int high) {
        if (high <= low) return -1;
        int middle = low + (high - low) / 2;
        int compare = a[middle].compareTo(key);
        if (compare > 0) return search(key, a, low, middle);
        else if (compare < 0) return search(key, a, middle + 1, high);
        else return middle;
    }

    public static void main(String[] args) {
        In list = new In(args[0]);
        In allow = new In(args[1]);
        String s = list.readAll();
        String[] words = s.split("\\s+");
        Arrays.sort(words);
        while (allow.hasNextLine()) {
            String key = allow.readString();
            if (search(key, words) < 0) StdOut.println(key);
        }
    }
}
