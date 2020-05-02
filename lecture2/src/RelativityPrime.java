public class RelativityPrime {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for (int i = n; i > 0 ; i--) {
            for (int j = n; j > 0 ;j-- ) {
                if (recursiveGCD(i,j)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }
    private static boolean recursiveGCD(int a, int b){
        //base case
        if (b== 0){
            if (a == 1){
                return true;
            } else {
                return false;
            }
        }
        return recursiveGCD(b, a%b);
    }
}
