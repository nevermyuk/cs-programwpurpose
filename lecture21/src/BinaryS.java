/*
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


public class BinaryS {
    public static int search(String key, String[] a) {
        return search(key, a, 0, a.length);
    }

    public static int search(String key, String[] a, int low, int high) {
        if (high <= low) return -1;
        int middle = low + (high - low) / 2;
        int compare = a[middle].compareTo(key);
        if (compare > 0) return search()
    }

    public static void main(String[] args) {

    }
}
