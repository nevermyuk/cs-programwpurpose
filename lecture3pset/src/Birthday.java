public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int i = 1;
        double fraction = 0.0;
        int[] people = new int[n+2];
        while (fraction < 0.5) {
            for (int j = 0; j < trials; j++)
            {
                int numPeople = 0;
                boolean []seenBefore = new boolean[n];
                int peopleEnter = 1;
                while (peopleEnter < i + 1) {
                    int birthday = (int) (Math.random()*(n-1));
                    peopleEnter++;
                    if (seenBefore[birthday])
                    {
                        numPeople++;
                        break;
                    } else {
                        seenBefore[birthday] = true;
                    }
                }
                people[i] += numPeople;
            }
            fraction = (double) people[i]/ trials;
            int count = people[i] - people[i-1];
            System.out.println(i + "\t" + count + "\t" + fraction);
            i++;
        }
    }
}