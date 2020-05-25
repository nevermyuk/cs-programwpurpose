/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */


public class RevesPuzzle {

    // move n smallest discs from one pole to another, using the temp1 and temp2 poles
    private static void hanoi4(int n, String from, String temp1, String temp2, String to)
    {
        if (n == 0) return;
        int k = (int) Math.round((n + 1 - Math.sqrt(2 * n + 1)));
        hanoi4(k, from, to, temp2, temp1);
        hanoi(k, n-k, from, temp2, to);
        hanoi4(k, temp1, from, temp2, to);
    }

    // move k discs from one pole to another, using the temp pole
    private static void hanoi(int n, int k, String from, String temp, String to)
    {
        if (k == 0) return;
        hanoi(n, k-1, from, to, temp);
        StdOut.println("Move disc " + (n + k) + " from " + from + " to " + to);
        hanoi(n, k-1, temp, from, to);
    }

    public static void main(final String[] args)
    {
        final int n = Integer.parseInt(args[0]);
        hanoi4(n, "A", "B", "C", "D");
    }
}


