/* *****************************************************************************
 *  Name:              Ong Ze Quan
 *  Coursera User ID:  a38d36017834930a7ca9ce7b1ccf90d2
 *  Last modified:     03/05/2020
 **************************************************************************** */

public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    System.out.print("*  ");
                }
                else if (j > i && j <= (i + width)) {
                    System.out.print("*  ");
                }
                else if (j < i && j >= (i - width)) {
                    System.out.print("*  ");

                }
                else {
                    System.out.print("0  ");
                }
            }
            System.out.print("\n");
        }
    }
}
