/* *****************************************************************************
 *  Name:              Ong Ze Quan
 *  Coursera User ID:  a38d36017834930a7ca9ce7b1ccf90d2
 *  Last modified:     03/05/2020
 **************************************************************************** */

public class GeneralizedHarmonic {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        double ret = 0;
        for (int i = 1; i <= n; i++) {
            ret += (1/Math.pow(i, r));
        }
        System.out.print(ret);
    }
}
