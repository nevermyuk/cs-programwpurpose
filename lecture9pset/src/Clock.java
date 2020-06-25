/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Clock {
    private int hour;
    private int minute;
    public Clock(int h, int m)
    {
        if (!(h >= 0 && h <= 23)) throw new IllegalArgumentException("Hour not within Range");
        if (!(m >= 0 && m <= 59)) throw new IllegalArgumentException("Minute not within Range");
        hour = h;
        minute = m;

    }
    public Clock(String s)
    {
        if (s.length() != 5 || (!s.startsWith(":", 2))) throw new IllegalArgumentException("Please input in HH:MM format");
        int h = Integer.parseInt(s.substring(0,2));
        int m = Integer.parseInt(s.substring(3));
        if (!(h >= 0 && h <= 23)) throw new IllegalArgumentException("Hour not within Range");
        if (!(m >= 0 && m <= 59)) throw new IllegalArgumentException("Minute not within Range");
        hour = h;
        minute = m;
    }
    public String toString()
    {
        String hours = String.format("%02d", hour);
        String minutes = String.format("%02d", minute);
        return  hours + ":" + minutes;
    }
    public boolean isEarlierThan(Clock that)
    {
        if  (that.hour > this.hour) return true;
        if  (this.hour == that.hour && that.minute > this.minute ) return true;
        return false;
    }
    public void tic()
    {
        if (!(this.minute >= 59 )) this.minute += 1;
        else
            {
            this.minute = 0;
            if (!(this.hour >= 23 )) this.hour += 1;
            else this.hour = 0;
            }
    }
    public void toc(int delta)
    {
        int minute = delta % 60;
        int hour = (delta - minute) / 60;
        if (this.minute + minute > 59)
        {
            this.minute = (this.minute + minute) % 60;
            this.hour += 1;
        }
        else this.minute += minute;
        if (this.hour + hour > 23)
        {
            this.hour = (this.hour + hour) % 24;
        }
        else this.hour += hour;
    }
    public static void main(String[] args)
    {
        Clock test = new Clock("12:00");
        Clock test2 = new Clock("00:45");
        test.toc(4320);
        StdOut.println(test);
    }
}
