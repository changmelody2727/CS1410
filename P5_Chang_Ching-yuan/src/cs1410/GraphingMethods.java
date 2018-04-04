package cs1410;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Scanner;

public class GraphingMethods
{
    /**
     * Constant used to request a max operation
     */
    public final static int MAX = 0;

    /**
     * Constant used to request a min operation
     */
    public final static int MIN = 1;

    /**
     * Constant used to request a sum operation
     */
    public final static int SUM = 2;

    /**
     * Constant used to request an average operation
     */
    public final static int AVG = 3;

    /**
     * Constant used to request a diameter
     */
    private final static int DIAMETER = 300;

    /**
     * If names and values have different lengths, throws an IllegalArgumentException.
     * 
     * If values contains any non-positive numbers, throws an IllegalAgumentException.
     * 
     * If categories is of length zero, throws an IllegalArgumentException.
     * 
     * If categories contains any duplicates, throws an IllegalArgumentException.
     * 
     * If operation is anything other than SUM, AVG, MAX, or MIN, throws an IllegalArgumentException.
     * 
     * Put side-by-side, the lists "names" and "values" represent a table of values, where each row contains a name and
     * a value. For example, here is the table of values that might give the number of people named Zebediah in
     * different parts of four states.
     * 
     * <pre>
     *  Utah          5
     *  Nevada        6
     *  California   12
     *  Oregon        8
     *  Utah          9
     *  California   10
     *  Nevada        4
     *  Nevada        4
     *  Oregon       17
     *  California    6
     * </pre>
     * 
     * We can make a table of summaries by pairing each string c from the list "categories" with either the sum,
     * average, maximum, or minimum of the numbers paired with c in the table above. For example, if "categories" is
     * 
     * <pre>
     *  Utah
     *  Nevada
     *  California
     * </pre>
     * 
     * then, assuming we are summing, the table of summaries would be
     *
     * <pre>
     *  Utah       14 
     *  Nevada     14 
     *  California 28
     * </pre>
     * 
     * The method should calculate and return, as an ArrayList<Double>, the second column of the table of summaries. It
     * should use the value of the "operation" parameter to determine whether the values are combined by summing,
     * averaging, max-ing, or min-ing. (If, for any category, there are no values to sum, average, min, or max, the
     * method should throw an IllegalArgumentException.)
     * 
     * The order of the numbers in the returned ArrayList<Double> should correspond to the order of the categories in
     * the "categories" list.
     */
    public static ArrayList<Double> summarizeData (ArrayList<String> names, ArrayList<Double> values,
            ArrayList<String> categories, int operation)
    {
        // If names and values have different lengths, throws an IllegalArgumentException.
        if (names.size() != values.size())
        {
            throw new IllegalArgumentException();
        }

        // If values contains any non-positive numbers, throws an IllegalAgumentException.
        for (int i = 0; i < values.size(); i++)
        {
            if (values.get(i) <= 0)
            {
                throw new IllegalArgumentException();
            }
        }

        // If categories is of length zero, throws an IllegalArgumentException.
        if (0 == categories.size())
        {
            throw new IllegalArgumentException();
        }

        // If categories contains any duplicates, throws an IllegalArgumentException.
        ArrayList<String> duplicates = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++)
        {
            if (!duplicates.equals(categories.get(i)))
            {
                duplicates.add(categories.get(i));
            }

        }
        if (duplicates.size() != categories.size())
        {
            throw new IllegalArgumentException();
        }

        // If operation is anything other than SUM, AVG, MAX, or MIN, throws an IllegalArgumentException.
        if (operation != SUM && operation != MAX && operation != MIN && operation != AVG)
        {
            throw new IllegalArgumentException();
        }

        ArrayList<Double> summaries = new ArrayList<>();

        for (int i = 0; i < categories.size(); i++)
        {

            ArrayList<Double> stateValues = getStateValues(categories.get(i), names, values);

            if (operation == MAX)
            {
                summaries.add(getMaxValue(stateValues));
            }

            if (operation == MIN)
            {
                summaries.add(getMinValue(stateValues));
            }

            if (operation == AVG)
            {
                summaries.add(getAverage(stateValues));
            }

            if (operation == SUM)
            {
                summaries.add(getSum(stateValues));
            }

        }
        return summaries;

    }

    public static double getSum (ArrayList<Double> stateValues)
    {
        double sum = 0;
        int i = 0;
        while (i < stateValues.size())
        {
            sum += stateValues.get(i);
            i++;
        }
        return sum;
    }

    public static double getAverage (ArrayList<Double> stateValues)
    {
        double sum = 0;
        int count = 0;
        int i = 0;
        while (i < stateValues.size())
        {
            count++;
            sum += stateValues.get(i);
            i++;
        }

        if (count == 0)
        {
            return sum;
        }
        else
        {
            return sum / count;
        }

    }

    public static double getMinValue (ArrayList<Double> stateValues)
    {
        double bestSoFar = stateValues.get(0);
        int i = 0;
        while (i < stateValues.size())
        {
            double nextVal = stateValues.get(i);

            if (nextVal < bestSoFar)
            {
                bestSoFar = nextVal;
            }
            i++;

        }
        return bestSoFar;

    }

    public static double getMaxValue (ArrayList<Double> stateValues)
    {
        double bestSoFar = 0;
        int i = 0;
        while (i < stateValues.size())
        {
            double nextVal = stateValues.get(i);
            if (nextVal > bestSoFar)
            {
                bestSoFar = nextVal;
            }
            i++;
        }
        return bestSoFar;
    }

    public static ArrayList<Double> getStateValues (String state, ArrayList<String> names, ArrayList<Double> values)
    {
        ArrayList<Double> Values = new ArrayList<>();
        for (int i = 0; i < values.size(); i++)
        {
            if (state.equals(names.get(i)))
            {
                Values.add(values.get(i));
            }
        }
        return Values;
    }

    /**
     * If categories, summaries, or colors is empty, throws an IllegalArgumentException.
     * 
     * If categories, summaries, and colors don't have the same number of elements, throws an IllegalArgumentException.
     * 
     * If any of the numbers in summaries is non-positive, throws an IllegalArgumentException.
     * 
     * Otherwise, views the three lists as a table with a String, a double, and a Color in each column and displays the
     * data with either a pie chart (if usePieChart is true) or a bar graph (otherwise). Let SUM be the sum of all the
     * entries in summaries. The area of slice i (of a pie chart) and the length of bar i (in a bar graph) should be
     * proportional to categories[i]/SUM. The slice/bar should be labeled with categories[i] and summaries[i], and it
     * should be colored with colors[i].
     * 
     * For example, suppose we are given this data:
     * 
     * <pre>
     *  Utah       14    Color.RED
     *  Nevada     14    Color.BLUE
     *  California 28    Color.GREEN
     * </pre>
     * 
     * In a pie chart Utah and Nevada should each have a quarter of the pie and California should have half. In a bar
     * graph, California's line should be twice as long as Utah's and Nevada's.
     * 
     * The method should display the pie chart or bar graph by drawing on the g parameter. The example code below draws
     * both a pie chart and a bar graph for the situation described above.
     */
    public static void drawGraph (Graphics g, ArrayList<String> categories, ArrayList<Double> summaries,
            ArrayList<Color> colors, boolean usePieChart)
    {
        if (categories.size() == 0 && summaries.size() == 0 && colors.size() == 0)
        {
            throw new IllegalArgumentException();
        }

        if (categories.size() != summaries.size() || summaries.size() != colors.size()
                || categories.size() != colors.size())
        {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < summaries.size(); i++)
        {
            if (summaries.get(i) <= 0)
            {
                throw new IllegalArgumentException();
            }
        }
        double total = 0;
        for (int h = 0; h < summaries.size(); h++)
        {
            total += summaries.get(h);
        }

        // This is sample code that always draws the same charts and graphs
        if (usePieChart)
        {
            // getPieChart(g, categories, summaries, colors);

            int startAngle = 0;

            for (int i = 0; i < summaries.size(); i++)
            {
                int angleSize = (int) ((summaries.get(i) / total) * 360);

                g.setColor(colors.get(i));
                g.fillArc(10, 10, DIAMETER, DIAMETER, startAngle, angleSize + 2);
                g.fillRect(DIAMETER + 30, 10 + (i * 15), 10, 10);
                g.setColor(Color.black);
                g.drawString(categories.get(i) + " " + summaries.get(i), 350, 20 + (i * 15));

                startAngle += angleSize;
            }
        }
        else
        {
            // getBarChart(g, categories, summaries, colors);
            for (int i = 0; i < summaries.size(); i++)
            {

                int width = (int) ((summaries.get(i) / total) * 310);

                g.setColor(colors.get(i));
                g.fillRect(300 - width, 10 + (30 * i), width, 20);
                g.setColor(Color.black);
                g.drawString(categories.get(i) + " " + summaries.get(i), 330, 25 + (30 * i));
            }

        }
    }

    /**
     * The dataSource should consist of zero or more lines. Each line should consist of some text, followed by a tab
     * character, followed by a double literal, followed by a newline.
     * 
     * If any lines are encountered that don't meet this criteria, the method throws an IllegalArgumentException whose
     * message explains what is wrong.
     * 
     * Otherwise, for each line, the text before the tab is added to names, and the parsed double literal is added to
     * values.
     */
    public static void readTable (Scanner dataSource, ArrayList<String> names, ArrayList<Double> values)
    {
        while (dataSource.hasNextLine())
        {
            String line = dataSource.nextLine();
            String[] splitLine = line.split("\t");
            if (splitLine.length != 2)
            {
                throw new IllegalArgumentException();
            }

            names.add(splitLine[0]);
            try
            {
                values.add(Double.parseDouble(splitLine[1]));

            }
            catch (NumberFormatException e)
            {
                throw new IllegalArgumentException();
            }

        }

    }

}
