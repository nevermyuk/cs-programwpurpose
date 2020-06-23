/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Interval
{
    private final double min;
    private final double max;
    public Interval(double min, double max)
    {
        if (min <= max)
        {
         this.min = min;
         this.max = max;
        }
        else throw new IllegalArgumentException("Illegal Interval");
    }
    public double min() {
        return min;
    }
    public double max() {
        return max;
    }
    public Boolean contains(double x)
    {
        return (min < x) && ( x <= max);
    }
    public double length() {
        return max - min;
    }
    public Boolean intersects(Interval b)
    {
        if (this.max < b.min) return false;
        if (b.max < this.min) return false;
        return true;
    }
    public String toString()
    {
        return "[" + min + "," + max + "]";
    }
    public static void main(String[] args) {
        Interval[] intervals = new Interval[4];
        intervals[0] = new Interval(15.0,33.0);
        intervals[1] = new Interval(45.0,60.0);
        intervals[2] = new Interval(20.0,70.0);
        intervals[3] = new Interval(46.0,55.0);
        for (int i = 0; i < intervals.length ; i++)
        {
         StdOut.println(intervals[i]);
         StdOut.println();
        }
        StdOut.println(intervals[2].max());
    }
}
