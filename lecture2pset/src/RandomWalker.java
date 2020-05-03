/* *****************************************************************************
 *  Name:              Ong Ze Quan
 *  Coursera User ID:  a38d36017834930a7ca9ce7b1ccf90d2
 *  Last modified:     03/05/2020
 **************************************************************************** */

public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        int steps = 0;
        System.out.println("(" + x + ", " + y + ")");
        while (Math.abs(x) + Math.abs(y) != r && Math.abs(x) + Math.abs(y) < r) {
            double probability = Math.random();
            if (probability <= 0.25) {
                y++;
                steps++;
            }
            else if (probability <= 0.5) {
                x++;
                steps++;
            }
            else if (probability <= 0.75) {
                y--;
                steps++;
            }
            else {
                x--;
                steps++;
            }
            System.out.println("(" + x + ", " + y + ")");
        }
        System.out.println("steps = " + steps);
    }
}
