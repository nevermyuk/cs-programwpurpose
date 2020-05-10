/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */
public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = 0;
        int[] frequency = new int[m+1];
        double[] pilog = new double[m+1];
        double ret = 0.0;
        while (!StdIn.isEmpty())
        {
            int x = StdIn.readInt();
            n++;
            frequency[x]++;
        }
        for (int i = 1; i < frequency.length ; i++) {
            double proportions;
            if (frequency[i] == 0) {
                pilog[i] = 0;
            }
            else {
                proportions = ((double) frequency[i] / n);
                pilog[i] = -proportions * (Math.log(proportions) / Math.log(2));
            }
        }
        for (int i = 1; i < pilog.length ; i++) {
            ret+=pilog[i];
        }
        System.out.printf("%.4f",ret);
    }
}
