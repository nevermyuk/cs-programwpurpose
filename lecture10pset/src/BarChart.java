/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.TreeMap;

public class BarChart {

    // color pallete for bars
    private static final Color[] COLORS = initColors();

    // instance variable
    private final String title;
    private final String xAxisLabel;
    private final String dataSource;

    // Arraylist object
    private ArrayList<String> names;
    private ArrayList<Integer> values;
    private ArrayList<Color> colors;

    // Treemap
    private TreeMap<String,Color> colorOf;

    // caption
    private String caption;

    // max value
    private int maxValue = 0;
    private boolean isSetMaxValue = false;

    // Create a bar chart with the given title, x-axis label and data source.
    public BarChart(String title, String xAxisLabel, String dataSource)
    {
        if (title == null ) throw new IllegalArgumentException("title is null");
        if (xAxisLabel == null ) throw new IllegalArgumentException("xAxisLabel is null");
        if (dataSource == null ) throw new IllegalArgumentException("dataSource is null");
        this.title = title;
        this.xAxisLabel = xAxisLabel;
        this.dataSource = dataSource;
        colorOf = new TreeMap<String, Color>();
        reset();
    }
    // initialize Colors;
    private static Color[] initColors()
    {
        // 12 colors from http://colorbrewer2.org/#type=qualitative&scheme=Set3&n=12
        String[] hex12 = {
                          "#a6cee3", "#1f78b4", "#b2df8a", "#33a02c",
                          "#fb9a99", "#e31a1c", "#fdbf6f", "#ff7f00",
                          "#cab2d6", "#6a3d9a", "#ffff99", "#b15928"
                          };
        // 20 colors from https://vega.github.io/vega/docs/schemes/
        String[] hex20 =  {
                            "#aec7e8", "#c5b0d5", "#c49c94", "#dbdb8d", "#17becf",
                            "#9edae5", "#f7b6d2", "#c7c7c7", "#1f77b4", "#ff7f0e",
                            "#ffbb78", "#98df8a", "#d64c4c", "#2ca02c", "#9467bd",
                            "#8c564b", "#ff9896", "#e377c2", "#7f7f7f", "#bcbd22"
                          };

        // use 20 colors
        Color[] colors = new Color[hex20.length];
        for (int i = 0; i < hex20.length; i++)
            colors[i] = Color.decode(hex20[i]);

        return colors;
    }
    /*
    Sets max x-value of the bar chart.
     */
    public void setMaxValue(int maxValue)
    {
        if(maxValue <= 0) throw new IllegalArgumentException("Maximum value must be positive");
        this.isSetMaxValue = true;
        this.maxValue = maxValue;
    }
    /**
     * Set caption of bar chart
     * @param caption the caption
     *
     */
    public void setCaption(String caption)
    {
        if (caption == null) throw new IllegalArgumentException("Caption is null");
        this.caption = caption;
    }
    /**
     * Adds a bar to bar chart
     * Length of bar is proportional to its value.
     * The bars are drawn from top to bottom in the order they are added.
     * All bars are from same category drawn with same color;
     *
     * @param name  the name of the bar
     * @param value the value of the bar
     * @param category the category of the bar
     */
    public void add(String name, int value, String category)
    {
        if (name == null ) throw new IllegalArgumentException("name is null");
        if (category == null ) throw new IllegalArgumentException("category is null");
        if (value <= 0 ) throw new IllegalArgumentException("value must be positive");

        if (!colorOf.containsKey(category))
        {
            colorOf.put(category,COLORS[colorOf.size() % COLORS.length]);
        }

        Color color = colorOf.get(category);
        names.add(name);
        values.add(value);
        colors.add(color);
    }
    public void reset()
    {
        names = new ArrayList<String>();
        values = new ArrayList<Integer>();
        colors = new ArrayList<Color>();
        caption = "";
    }
    /*
     compute units (multiple of 1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, ...)
     so that between 4 and 8 axes labels
     */
    private static int getUnit(double xmax)
    {
        int units = 1;
        while (Math.floor(xmax / units) >= 8)
        {
            if ( units % 9 == 2) units = units * 5 /2;
            else units = units * 2;
        }
        return units;
    }
    public void draw()
    {
        // nothing to draw
        if (names.isEmpty()) return;
        // Leave room for at least 8 bars.
        int numberOfBars = Math.max(8, names.size());
        // set the scale of coordinate axes
        double xmax = Double.NEGATIVE_INFINITY;
        for (int value : values)
        {
            if (value > xmax) xmax = value;
        }
        if (isSetMaxValue) xmax = maxValue;

        StdDraw.setXscale(-0.01 * xmax, 1.2 * xmax);
        StdDraw.setYscale(-0.01 * numberOfBars, numberOfBars * 1.25);

        // draw title

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setFont(new Font("SansSerif", Font.BOLD, 24));
        StdDraw.text( 0.6 * xmax, numberOfBars * 1.2, title);

        // draw x -axis label
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 16));
        StdDraw.textLeft(0, numberOfBars*1.10, xAxisLabel);

        // draw axes label
        int units = getUnit(xmax);
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 12));
        for (int unit = 0; unit <= xmax; unit += units) {
            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.text(unit, numberOfBars * 1.02, String.format("%,d", unit));
            StdDraw.setPenColor(new Color(230, 230, 230));
            StdDraw.line(unit, 0.1, unit, numberOfBars * 1.0);
        }

        // draw caption
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        if (caption.length() <= 4) StdDraw.setFont(new Font("SansSerif",Font.BOLD,100));
        else if (caption.length() <= 8) StdDraw.setFont(new Font("SansSerif",Font.BOLD,60));
        else StdDraw.setFont(new Font("SansSerif",Font.BOLD,40));
        StdDraw.textRight(1.15 * xmax, 0.2 * numberOfBars, caption);

        // draw data source acknowledgement
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.setFont(new Font("SansSerif",Font.PLAIN,14));
        StdDraw.textRight(1.14 * xmax, 0.1 * numberOfBars, dataSource);

        // draw bars
        for (int i = 0; i < names.size() ; i++)
        {
            String name = names.get(i);
            int value = values.get(i);
            Color color = colors.get(i);
            // draw bar
            StdDraw.setPenColor(color);
            StdDraw.filledRectangle(0.5 * value,numberOfBars - i - 0.5, 0.5 * value, 0.4);
            StdDraw.setPenColor(StdDraw.BLACK);
            // draw name to bar
            int fontSize = (int) Math.ceil(14 * 10.0 / numberOfBars);
            StdDraw.setFont(new Font("SansSerif", Font.BOLD, fontSize));
            StdDraw.textRight(value - 0.01 * xmax , numberOfBars - i - 0.5 , name);
            // draw value
            StdDraw.setFont(new Font("SansSerif",Font.PLAIN,fontSize));
            StdDraw.setPenColor(StdDraw.DARK_GRAY);
            StdDraw.textLeft(value + 0.01 * xmax, numberOfBars - i - 0.5, String.format("%,d", value));
        }

    }
    public static void main(String[] args)
    {
        // create bar chart
        String title = " The 10 most populous cities";
        String xAxis = "Population (thousands)";
        String source = "Source: United Nations";
        BarChart chart = new BarChart(title, xAxis, source);
        chart.setCaption("2018");
        // add bars to chart
        chart.add("Tokyo",       38194, "East Asia");
        chart.add("Delhi",       27890, "South Asia");
        chart.add("Shanghai",    25779, "East Asia");
        chart.add("Beijing",     22674, "East Asia");
        chart.add("Mumbai",      22120, "South Asia");
        chart.add("São Paulo",   21698, "Latin America");
        chart.add("Mexico City", 21520, "Latin America");
        chart.add("Osaka",       20409, "East Asia");
        chart.add("Cairo",       19850, "Middle East");
        chart.add("Dhaka",       19633, "South Asia");

        StdDraw.setCanvasSize(1000,700);
        StdDraw.enableDoubleBuffering();
        chart.draw();
        StdDraw.show();
    }
}
