/*
1.4.33 Find a duplicate. Given an integer array of length n, with each value between 1 and n, write a code fragment to determine whether there are any duplicate values. You may not use an extra array (but you do not need to preserve the contents of the given array.)

 */

public class FindDuplicateArray {

    public static void main(String[] args) {
        int[] arr = {5, 4, 7, 13, 42, 23, 14, 2, 1};
        boolean duplicate = false;
        outerloop:
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    duplicate = true;
                    System.out.print("A duplicate was found, " + arr[j]);
                    break outerloop;
                }
            }
        }
        if (!duplicate) {
            System.out.print("No duplicates were found");
        }
    }
}
