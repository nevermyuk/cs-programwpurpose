/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */
// Reference from https://lodev.org/cgtutor/filtering.html

import java.awt.Color;

public class KernelFilter {

    // // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture)
    {
        int[][] filter = {
                { 1,  2,  1 },
                { 2,  4,  2 },
                { 1,  2,  1 }
        };
        int width = picture.width();
        int height = picture.height();
        Picture pic = new Picture(width, height);
        for (int y = 1; y < height - 1 ; y++) {
            for (int x = 1; x < width - 1 ; x++) {
                int r = 0;
                int g = 0;
                int b = 0;
                for (int yy = 0; yy < 3 ; yy++) {
                    for (int xx = 0; xx < 3 ; xx++) {
                        Color c = picture.get(x-1+yy, y-1+xx);
                        r += c.getRed() * filter[yy][xx];
                        g += c.getGreen() * filter[yy][xx];
                        b += c.getBlue() * filter[yy][xx];
                    }
                }
                r = truncate((int) ((int) r*0.0625));
                g = truncate((int) ((int) g*0.0625));
                b = truncate((int) ((int) b*0.0625));

                Color c = new Color(r,g,b);
                pic.set(x, y, c);
            }
            if (y % 20 == 0) picture.show();
        }
        return pic;
    }
    public static int truncate(int a) {
        if      (a <   0) return 0;
        else if (a > 255) return 255;
        else              return a;
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture pic = new Picture(width, height);
        for (int y = 1; y < height - 1; y++) {
            for (int x = 1; x < width - 1; x++) {
                Color c00 = picture.get(x-1, y-1);
                Color c01 = picture.get(x-1, y);
                Color c02 = picture.get(x-1, y+1);
                Color c10 = picture.get(x, y-1);
                Color c11 = picture.get(x, y);
                Color c12 = picture.get(x, y+1);
                Color c20 = picture.get(x+1, y-1);
                Color c21 = picture.get(x+1, y);
                Color c22 = picture.get(x+1, y+1);
                int r = (c01.getRed()*-1) +
                        (c10.getRed()*-1) + (c11.getRed() * 5) + (c12.getRed()* -1) +
                        (c21.getRed()*-1) ;
                int g = (c01.getGreen()*-1) +
                        (c10.getGreen()*-1) + (c11.getGreen() * 5) + (c12.getGreen()* -1) +
                        (c21.getGreen()*-1) ;
                int b = (c01.getBlue()*-1) +
                        (c10.getBlue()*-1) + (c11.getBlue() * 5) + (c12.getBlue()* -1) +
                        (c21.getBlue()*-1) ;
                Color c = new Color(truncate(r), truncate(g), truncate(b));
                pic.set(x, y, c);
            }
            if (y % 20 == 0) picture.show();
        }
        return pic;
    }


    // // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture)
    {
        int[][] filter = {
                { -1,  -1,  -1 },
                { -1,  8,  -1 },
                { -1,  -1,  -1 }
        };
        int width = picture.width();
        int height = picture.height();
        Picture pic = new Picture(width, height);
        for (int y = 1; y < height - 1 ; y++) {
            for (int x = 1; x < width - 1 ; x++) {
                int r = 0;
                int g = 0;
                int b = 0;
                // get neighbouring 3x3
                for (int yy = 0; yy < 3 ; yy++) {
                    for (int xx = 0; xx < 3 ; xx++) {
                        Color c = picture.get(x-1+yy, y-1+xx);
                        r += c.getRed() * filter[yy][xx];
                        g += c.getGreen() * filter[yy][xx];
                        b += c.getBlue() * filter[yy][xx];
                    }
                }
                r = truncate(r);
                g = truncate(g);
                b = truncate(b);

                Color c = new Color(r,g,b);
                pic.set(x, y, c);
            }
            if (y % 20 == 0) picture.show();
        }
        return pic;
    }

    // // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture)
    {
        int[][] filter = {
                { -2,  -1,  0 },
                { -1,  1,  1 },
                { 0,  1,  2 }
        };
        int width = picture.width();
        int height = picture.height();
        Picture pic = new Picture(width, height);
        for (int y = 1; y < height - 1 ; y++) {
            for (int x = 1; x < width - 1 ; x++) {
                int r = 0;
                int g = 0;
                int b = 0;
                // get neighbouring 3x3
                for (int yy = 0; yy < 3 ; yy++) {
                    for (int xx = 0; xx < 3 ; xx++) {
                        Color c = picture.get(x-1+yy, y-1+xx);
                        r += c.getRed() * filter[yy][xx];
                        g += c.getGreen() * filter[yy][xx];
                        b += c.getBlue() * filter[yy][xx];
                    }
                }
                r = truncate(r);
                g = truncate(g);
                b = truncate(b);

                Color c = new Color(r,g,b);
                pic.set(x, y, c);
            }
            if (y % 20 == 0) picture.show();
        }
        return pic;
    }

    // // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture)
    {
        int[][] filter = {
                { 1,0,0,0,0,0,0,0,0 },
                { 0,1,0,0,0,0,0,0,0 },
                { 0,0,1,0,0,0,0,0,0 },
                { 0,0,0,1,0,0,0,0,0 },
                { 0,0,0,0,1,0,0,0,0 },
                { 0,0,0,0,0,1,0,0,0 },
                { 0,0,0,0,0,0,1,0,0 },
                { 0,0,0,0,0,0,0,1,0 },
                { 0,0,0,0,0,0,0,0,1 }
                };
        int width = picture.width();
        int height = picture.height();
        Picture pic = new Picture(width, height);
        for (int y = 1; y < height - 1 ; y++) {
            for (int x = 1; x < width - 1 ; x++) {
                int r = 0;
                int g = 0;
                int b = 0;
                for (int yy = 0; yy < 9  ; yy++) {
                    for (int xx = 0; xx < 9 ; xx++) {
                        int imageX = (x - 9 / 2 + xx + width) % width;
                        int imageY = (y - 9 / 2 + yy + height) % height;
                        Color c = picture.get(imageX, imageY);
                        r += c.getRed() * filter[yy][xx];
                        g += c.getGreen() * filter[yy][xx];
                        b += c.getBlue() * filter[yy][xx];
                    }
                }
                r = truncate((int) ((int) r*0.11111111111));
                g = truncate((int) ((int) g*0.11111111111));
                b = truncate((int) ((int) b*0.11111111111));

                Color c = new Color(r,g,b);
                pic.set(x, y, c);
            }
            if (y % 20 == 0) picture.show();
        }
        return pic;
    }

    // Test client (ungraded).
    public static void main(String[] args)
    {
        Picture pic1 = new Picture(args[0]);
        Picture pic2 = motionBlur(pic1);
        pic1.show();
        pic2.show();
    }

}