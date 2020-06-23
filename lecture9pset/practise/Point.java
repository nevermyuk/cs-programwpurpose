/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */


public class Point {
    final private double x;
    final private double y;
    public Point(double ix , double iy)
    {
        this.x = ix;
        this.y = iy;
    }
    public double distanceTo(Point q)
    {
        double distance = Math.sqrt(Math.pow((this.x - q.x),2) + Math.pow((this.y-q.y),2));
        return distance;
    }
    public String toString()
    {
        return "[" + x + ", " + y + "]";
    }
    public static void main(String[] args) {
        Point test1 = new Point(2,-1);
        Point test2 = new Point(-2,2);
        StdOut.print(test1.distanceTo(test2));
    }
}
