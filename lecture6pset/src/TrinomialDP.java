/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class TrinomialDP {
    public static long trinomial(int n, int k)
    {
        int absk = Math.abs(k);

        long[][] arr = new long[n + 1][absk + n + 1 ];
        arr[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            // T(n-1,k+1) ;  k always > n or T(k,n) = T(0,0).
            for (int j = 0; j <= absk + n - 1; j++) {
                // T(n,k) = T(n,-k) for all n and k. So j > i = T(n,k) = 0.
                if (j > i) arr[i][j] = 0;
                arr[i][j] = arr[i-1][Math.abs(j-1)] + arr[i-1][j] + arr[i-1][j+1];
            }

        }
        return arr[n][absk];
    }
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}
