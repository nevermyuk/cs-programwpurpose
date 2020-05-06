/* *****************************************************************************
 *  Name:              Ong Ze Quan
 *  Coursera User ID:  123456
 *  Last modified:     06/05/2020
 **************************************************************************** */

public class DiscreteDistribution {
    public static void main(String[] args) {
        // number of random indices
        int m = Integer.parseInt(args[0]);
        int n = args.length;
        int[] sum = new int[n];
        // cumulative sums
        for (int i = 1; i < n; i++) {
            sum[i] = Integer.parseInt(args[i]);
            sum[i] += sum[i-1];
        }
        // compute sum of all frequencies
        for (int i = 0; i < m ;i++) {
            // r is between 0 and Sn - 1
            int r = (int)(Math.random() * (sum[n -1] -1));
            // index  lesser than or equal to r. Between 1 and n.
            int index = 0;
            while (sum[index] <= r)
            {
                index++;
            }
            System.out.print(index + " ");
        }

    }
}
