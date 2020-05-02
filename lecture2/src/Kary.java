public class Kary {
    public static void main(String[] args) {
        long i = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        String results = "";
        while ( i != 0) {
            long remainder = i % k;
            i = (i - remainder) / k;
            if (remainder > 9) {
                if (remainder == 10) {
                    remainder = 'A';
                }
                if (remainder == 11) {
                    remainder = 'B';
                }
                if (remainder == 12) {
                    remainder = 'B';
                }
                if (remainder == 13) {
                    remainder = 'C';
                }
                if (remainder == 14) {
                    remainder = 'D';
                }
                if (remainder == 15) {
                    remainder = 'E';
                }
                if (remainder == 16) {
                    remainder = 'F';
                }
                results = Character.toString((char)remainder) + results;
            } else {
                results = String.valueOf(remainder) + results;
            }
        }
        System.out.println(results);
    }
}
