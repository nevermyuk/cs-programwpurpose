public class ActivationFunction {
    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        double ret = 0;
        if (Double.isNaN(x)) ret = Double.NaN;
        else {
            if (x < 0) ret = 0.0;
            if (x == 0) ret = 0.5;
            if (x > 0) ret = 1.0;
        }
        return ret;
    }
    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        return 1/(1+ Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        return (Math.exp(x)-Math.exp(-x))/(Math.exp(x)+Math.exp(-x));
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        return x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        double ret = 0;
        if (x <= -2) ret = -1;
        else if (x > -2 && x < 0) ret = x + (Math.pow(x,2)/4);
        else if (x >= 0 && x < 2) ret = x -(Math.pow(x,2)/4);
        else if (x >= 2) ret = 1.0;
        return ret;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        StdOut.println("heaviside(" +x + ") = "+ heaviside(x));
        StdOut.println("sigmoid(" +x + ") = "+sigmoid(x));
        StdOut.println("tanh(" +x + ") = "+tanh(x));
        StdOut.println("softsign(" +x + ") = "+softsign(x));
        StdOut.println("sqnl(" +x + ") = "+sqnl(x));
    }
}
