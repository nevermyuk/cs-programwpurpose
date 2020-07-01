/*
https://introcs.cs.princeton.edu/java/42sort/Merge.java.html

- Divide array into two half
- Recursive sort each half
- Merge two halve to make a sorted whole.

Pseudocode -
    Merge
        / Iterate over array
        for loop ++
           if low == middle; move element in mid-high array to aux. a[middle++]
           else if middle == high; move element in low-mid array to aux. a[lower++]
           else if a[middle] compared to a[low] < 0; move element in mid-high array to aux. a[middle++]
           else move element in low-mid array to aux a[lower++]

        / copy from aux into original array.

        for loop ++
            a[low+index] = aux[index];


     Sort
        allocate an array once

     Recursive Sort that takes in indices
        N = high - low
        if N <= 1 return; // list is empty
        sort lower indexes
        sort higher indexes
        merge

 */

public class MS {
    private static String[] aux;

    public static void merge(String[] a, int low, int middle, int high) {

        int i = low, j = middle, N = high - low;
        for (int k = 0; k < N; k++) {
            if (i == middle) aux[k] = a[j++];
            else if (j == high) aux[k] = a[i++];
            else if (a[j].compareTo(a[i]) < 0) aux[k] = a[j++];
            else aux[k] = a[i++];
        }
        for (int k = 0; k < N; k++) {
            a[low + k] = aux[k];
        }
    }

    public static void sort(String[] a) {
        aux = new String[a.length];
        sort(a, 0, a.length);
    }

    public static void sort(String[] a, int low, int high) {
        int N = high - low;
        if (N <= 1) return; // empty list
        int middle = low + N / 2;
        sort(a, low, middle);
        sort(a, middle, high);
        merge(a, low, middle, high);
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] a = in.readAllStrings();
        sort(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }

    }
}


