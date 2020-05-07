/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        boolean[][] mines = new boolean[m+2][n+2];
        int [][] neighbour = new int[m+2][n+2];
        int total = k;

        // choose k cells to contain mines
        while (total > 0) {
            int rr = 1 + (int) (Math.random() * m);
            int cw = 1 + (int) (Math.random() * n);
            if (!mines[rr][cw]) {
                mines[rr][cw] = true;
                total--;
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (mines[i][j])
                {
                    // set neighbour distance
                    // above
                    neighbour[i-1][j-1]++;
                    neighbour[i-1][j]++;
                    neighbour[i-1][j+1]++;
                    // same row
                    neighbour[i][j-1]++;
                    neighbour[i][j+1]++;
                    // below
                    neighbour[i+1][j-1]++;
                    neighbour[i+1][j]++;
                    neighbour[i+1][j+1]++;
                }

            }
        }

        for (int i = 1; i < m +1; i++)
        {
            for (int j = 1; j < n + 1; j++) {
                if (mines[i][j])
                {
                    System.out.print("*  ");
                } else {
                    System.out.print(neighbour[i][j]+ "  ");
                }
            }
            System.out.println();
        }
    }
}
