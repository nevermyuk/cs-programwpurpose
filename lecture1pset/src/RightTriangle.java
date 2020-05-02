public class RightTriangle {
    public static void main(String[] args) {
        int x1 = Integer.parseInt(args[0]);
        int x2 = Integer.parseInt(args[1]);
        int x3 = Integer.parseInt(args[2]);
        int a;
        int b;
        int c;
        c = Math.max(Math.max(x1, x2), x3);
        a = Math.min(Math.min(x1, x2), x3);
        b = x3 + x2 + x1 - a - c;
        System.out.println(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2));
    }
}
