/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */


public class LRS {
    private static String lcp(String s, String t) {
        int N = Math.min(s.length(), t.length());
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) != t.charAt(i)) return s.substring(0, i);
        }
        return s.substring(0, N);
    }

    public static String lrsBrute(String s) {
        int N = s.length();
        String lrs = "";
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                String x = lcp(s.substring(i, N), s.substring(j,
                                                              N)); // for every position in the string, compare with every positon later in the string
                StdOut.println(x);
                if (x.length() > lrs.length())
                    lrs = x; // check if x is a longer LRS then what we seen, if it is, replace lrs.

            }
        }
        return lrs;
    }

    public static String lrsSuffix(String s) {
        int N = s.length();
        String[] suffixes = new String[N];
        for (int i = 0; i < N; i++)
            suffixes[i] = s.substring(i, N);
        Merge.sort(suffixes);

        String lrs = "";
        for (int i = 0; i < N - 1; i++) {
            String x = lcp(suffixes[i], suffixes[i + 1]);
            if (x.length() > lrs.length()) lrs = x;
        }
        return lrs;
    }

    public static void main(String[] args) {
        String s = StdIn.readAll();
        StdOut.println(lrsSuffix(s));
    }
}
