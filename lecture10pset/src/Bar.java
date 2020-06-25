/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Arrays;

public class Bar implements Comparable<Bar> {

    private final String n;
    private final int v;
    private final String c;

    // Create new bar
    public Bar(String name, int value, String category)
    {
        if (name == null) throw new IllegalArgumentException("name is null");
        if (value < 0) throw new IllegalArgumentException("n is negative");
        if (category == null) throw new IllegalArgumentException("category is null");
        n = name;
        v = value;
        c = category;
    }
    public String getName()
    {
        return n;
    }
    public int getValue()
    {
        return v;
    }
    public String getCategory()
    {
        return c;
    }
    /* Compare 2 bares
     if value of the invoking object is { less than, equal to, greater than } the value of the argument object.
            return a { negative integer, zero, positive integer }
    */

    public int compareTo(Bar that)
    {
        if (that == null ) throw new NullPointerException("Please input a Bar class object");
        if (this.v < that.v) return this.v - that.v;
        else if (this.v == that.v ) return 0;
        else return this.v - that.v;
    }

    public String toString()
    {
        return v + " ,"+ n;
    }
    public static void main(String[] args) {
        Bar[] bars = new Bar[10];
        bars[0] = new Bar("Beijing",     22674, "East Asia");
        bars[1] = new Bar("Cairo",       19850, "Middle East");
        bars[2] = new Bar("Delhi",       27890, "South Asia");
        bars[3] = new Bar("Dhaka",       19633, "South Asia");
        bars[4] = new Bar("Mexico City", 21520, "Latin America");
        bars[5] = new Bar("Mumbai",      22120, "South Asia");
        bars[6] = new Bar("Osaka",       20409, "East Asia");
        bars[7] = new Bar("São Paulo",   21698, "Latin America");
        bars[8] = new Bar("Shanghai",    25779, "East Asia");
        bars[9] = new Bar("Tokyo",       38194, "East Asia");
        Arrays.sort(bars);
    }
}
