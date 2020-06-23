/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */


public class ColorHSB {
    private final int hue;
    private final int saturation;
    private final int brightness;
    public ColorHSB(int h,int s, int b)
    {
        if (!(h >= 0 && h <= 359))
            throw new IllegalArgumentException("Hue outside of desired range");
        if (!(s >= 0 && s <= 100))
            throw new IllegalArgumentException("Saturation outside of desired range");
        if (!(b >= 0 && b <= 100))
            throw new IllegalArgumentException("Brightness outside of desired range");
        hue = h;
        saturation = s;
        brightness = b;
    }
    public String toString()
    {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
    }
    public boolean isGrayscale()
    {
        if (saturation == 0 || brightness == 0) return true;
        return false;
    }
    public int distanceSquaredto(ColorHSB that)
    {
        int dh = this.hue - that.hue;
        int ds = this.saturation - that.saturation;
        int db = this.brightness - that.brightness;
        int squaredh = (int) Math.min(Math.pow(dh, 2), Math.pow((360 - Math.abs(dh)), 2));
        int distance = (int) (squaredh + Math.pow(ds, 2) + Math.pow(db, 2));
        return distance;

    }
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB input = new ColorHSB(h,s,b);
        int distance = 1000;
        ColorHSB output = new ColorHSB(0,0,0);
        String ocolor = "test";
        while (!StdIn.isEmpty())
        {
            String fcolor = StdIn.readString();
            int fh = StdIn.readInt();
            int fs = StdIn.readInt();
            int fb = StdIn.readInt();
            ColorHSB temp = new ColorHSB(fh,fs,fb);
            if (input.distanceSquaredto(temp) < distance)
            {
                distance = input.distanceSquaredto(temp);
                output = new ColorHSB(fh,fs,fb);
                ocolor = fcolor;
            }
        }
        StdOut.print(ocolor + " ");
        StdOut.println(output);
    }
}
