public class Stats5 {
    public static void main(String[] args) {
        int n = 5;
        double x1 = Math.random();
        double x2 = Math.random();
        double x3 = Math.random();
        double x4 = Math.random();
        double x5 = Math.random();

        // Print the values

        System.out.println(x1);
        System.out.println(x2);
        System.out.println(x3);
        System.out.println(x4);
        System.out.println(x5);

        double minimum = Math.min(x5,Math.min(x4,Math.min(x3,Math.min(x1,x2))));
        double max = Math.max(x5,Math.max(x4,Math.max(x3,Math.max(x1,x2))));
        double avg = (x1+x2+x3+x4+x5)/n;

        System.out.print("Minimum is : " + minimum);
        System.out.print("\nMaximum is : " + max);
        System.out.print("\nAverage is : "+ avg);
    }
}
