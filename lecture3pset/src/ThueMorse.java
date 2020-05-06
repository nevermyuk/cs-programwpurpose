/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        // build up morse sequence
        String thue = "0";
        String morse = "1";
        for (int i = 1; i <n ; i++) {
            String t = thue;
            String m = morse;
            thue += m;
            morse += t;
        }
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                if (thue.charAt(i) != thue.charAt(j)) {
                    System.out.print("-  ");
                } else {
                    System.out.print("+  ");
                }
            }
            System.out.println();
        }


    }
}
