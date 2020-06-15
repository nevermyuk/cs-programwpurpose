/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Huntingtons {
    public static int maxRepeats(String dna) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < dna.length() - 3 ; i++) {
            String codon = dna.substring(i,i+3);
            if (codon.startsWith("T")) count = 0;
            if (codon.equals("CAG")) count++;
            if (count >= max) max = count;
        }
        return max;
    }
    public static String removeWhitespace(String s) 
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (c != '\n' && c != '\t' && c != ' ') sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String filename= args[0];
        In input = new In(filename);
        String s = input.readAll();
        String n = removeWhitespace(s);
        StdOut.println("Total : " + maxRepeats(n));
    }

}
