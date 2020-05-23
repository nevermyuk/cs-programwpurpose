/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class AudioCollage {
    // Returns a new array that rescales a[] by multiplicative factor of alpha
    public static double[] amplify(double[] a , double alpha)
    {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length ; i++) {
            b[i] = a[i] * alpha;
        }
        return b;
    }

    // Return a new array that is the reverse of a[].
    public static double[] reverse(double[] a)
    {
        double [] b = new double[a.length];
        for (int i = 0; i < a.length ; i++) {
            b[i] = a[a.length - 1 - i];
        }
        return b;
    }

    // Return a new array that is the cncatenation of a[] and b[]
    public static double[] merge(double[] a, double[] b)
    {
        double[] c = new double[a.length+b.length];
        for (int i = 0; i < a.length; i++)
        {
            c[i] = a[i];
        }
        for (int i = a.length; i < a.length + b.length ; i++)
        {
            c[i] = b[i - a.length];
        }
        return c;
    }

    // Returns a new array that is the sum of a[] and b[]
    // padding the shorter array
    @SuppressWarnings("checkstyle:NoWhitespaceBefore")
    public static double[] mix(double[] a, double[] b)
    {
        int length = Math.max(a.length,b.length);
        double[] c = new double[length];
        double[] d = new double[length];
        // add padding for b array
        for (int i = 0; i < length ;i++) {
            if (i < b.length) c[i] = b[i];
            else c[i] = 0.0;
        }
        for (int i = 0; i < length ;i++)
        {
            d[i] = a[i] + c[i];
        }
        return d;
    }



    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha)
    {
        double[] b = new double[(int) Math.floor(a.length/alpha)];

        for (int i = 0; i < b.length; i++) {
            int sample = (int) Math.floor(i*alpha);
            b[i] = a[sample];
        }
        return b;
    }

    public static void main(String[] args) {
        double[] cow = StdAudio.read("cow.wav");
        double[] exposure = StdAudio.read("exposure.wav");
        int alpha = 2;
        StdAudio.play(amplify(cow,alpha));
        StdAudio.play(reverse(cow));
        StdAudio.play(merge(exposure,cow));
        StdAudio.play(mix(exposure,cow));
        StdAudio.play(changeSpeed(exposure,2));
    }
}
