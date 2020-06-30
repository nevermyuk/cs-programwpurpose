import java.util.Arrays;

/*
    Binary Search
    1. Sort
    2. Then Merge
    middle = low + (high - low)/2

    If high <= low , that means nothing in between.


*/
public class BS {
    public static int search(String key, String[] a) {
        return search(key, a, 0, a.length);
    }

    public static int search(String key, String[] a, int low, int high) {
        if (high <= low) return -1;
        int middle = low + (high - low) / 2;
        int compare = a[middle].compareTo(key);
        if (compare > 0) return search(key, a, low, middle);
        if (compare < 0) return search(key, a, middle + 1, high);
        return middle;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        String s = in.readAll();
        String[] words = s.split("\\s+");
        Arrays.sort(words);
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (search(key, words) < 0) StdOut.println(key);
        }
    }
}

