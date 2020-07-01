/*
 - Move down array
 - Each item bubble up above the larger one above it
 - Everything above current item is in order
 - Everything below is untouched.

 Pseudocode -
 Iterate through array.
   Iterate in reverse
     if previous element in array is bigger then current element.
       exchange position
     else
        break

 */

public class InsertionSort {
    public static void sort(String[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j - 1].compareTo(a[j]) > 0) {
                    exchange(a, j - 1, j);
                }
            }
        }
    }

    public static void exchange(String[] a, int previous, int current) {
        String temporary = a[previous];
        a[previous] = a[current];
        a[current] = temporary;
    }

    public static void main(String[] arg) {
        In in = new In(arg[0]);
        String[] input = in.readAllStrings();
        sort(input);
        for (int i = 0; i < input.length; i++) {
            StdOut.println(input[i]);
        }
    }
}
