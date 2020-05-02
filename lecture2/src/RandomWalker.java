public class RandomWalker {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double p;
        int[] coordinate = new int[2];
        int steps = 0;
        int positivebound = 2*n;
        int negativebound = -2*n;
        while (coordinate[0] != positivebound && coordinate[0] != negativebound && coordinate[1] != positivebound && coordinate[1] !=negativebound) {
            p = Math.random();
            if (p <= 0.25)
            {
                coordinate[0]++;
                steps++;
            } else if (p <= 0.5)
            {
                coordinate[0]--;
                steps++;
            } else if (p <= 0.75)
            {
                coordinate[1]++;
                steps++;
            } else
            {
                coordinate[1]--;
                steps++;
            }
        }
        System.out.print("X : "+coordinate[0] + " Y: "+coordinate[1] + "\n");
        System.out.print("It will take random walker "+ steps + " steps before hitting any boundary.");
    }
}
