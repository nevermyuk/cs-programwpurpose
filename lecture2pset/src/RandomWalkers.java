/* *****************************************************************************
 *  Name:              Ong Ze Quan
 *  Coursera User ID:  a38d36017834930a7ca9ce7b1ccf90d2
 *  Last modified:     03/05/2020
 **************************************************************************** */

public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int x = 0;
        int y = 0;
        int totalsteps = 0;
        for (int i = 0; i < trials; i++) {
            while (Math.abs(x) + Math.abs(y) != r && Math.abs(x) + Math.abs(y) < r) {
                double probability = Math.random();
                if (probability <= 0.25) {
                    y++;
                    totalsteps++;
                }
                else if (probability <= 0.5) {
                    x++;
                    totalsteps++;
                }
                else if (probability <= 0.75) {
                    y--;
                    totalsteps++;
                }
                else {
                    x--;
                    totalsteps++;
                }
            }
            x = 0;
            y = 0;
        }
        double avgsteps = (double) totalsteps/trials;
        System.out.print("average number of steps = " + avgsteps);
    }
}
