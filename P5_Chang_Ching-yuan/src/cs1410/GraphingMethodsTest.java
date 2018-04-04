package cs1410;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.Test;

public class GraphingMethodsTest
{

    @Test
    public void test ()
    {
        // This is a sample test that shows two ways to make assertions about ArrayLists.
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> values = new ArrayList<>();
        GraphingMethods.readTable(new Scanner("A\t45\nB\t50\n"), names, values);

        ArrayList<String> namesGoal = new ArrayList<>();
        namesGoal.add("A");
        namesGoal.add("B");
        assertEquals(namesGoal, names);

        assertEquals(2, values.size());
        assertEquals(45.0, values.get(0), 1e-6);
        assertEquals(50.0, values.get(1), 1e-6);

    }
    
    @Test
    public void testsummarizeData ()
    {
    	 ArrayList<String> names = new ArrayList<>();
         ArrayList<Double> values = new ArrayList<>();
         ArrayList<String> categories = new ArrayList<>();
         int operation = 0;
         
         categories.add("Utah");
         categories.add("California");
         categories.add("Navada");

         names.add("Utah");
         names.add("California");
         names.add("Navada");
         names.add("California");
         names.add("Utah");

         values.add(2.0);
         values.add(3.0);
         values.add(4.0);
         values.add(5.0);
         values.add(6.0);
         
         assertEquals(2.0, values.get(0), 1e-6);
         assertEquals(3.0, values.get(1), 1e-6);

    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testsummarizeData1 ()
    {
    	ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> values = new ArrayList<>();
        ArrayList<String> categories = new ArrayList<>();
        int operation = 0;
        
        categories.add("Utah");
        categories.add("California");
        categories.add("Navada");

        names.add("Utah");
        names.add("California");
        names.add("Navada");
        names.add("California");
        names.add("Utah");

        values.add(-2.0);
        values.add(3.0);
        values.add(4.0);
        values.add(5.0);
        values.add(6.0);
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testsummarizeData2 ()
    {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> values = new ArrayList<>();
        ArrayList<String> categories = new ArrayList<>();
        int operation = 0;
        

        names.add("Utah");
        names.add("California");
        names.add("Navada");
        names.add("California");

        values.add(2.0);
        values.add(3.0);
        values.add(4.0);
        values.add(5.0);
        values.add(6.0);
        
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void testsummarizeData3 ()
    {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> values = new ArrayList<>();
        ArrayList<String> categories = new ArrayList<>();
        int operation = 0;
        
        categories.add("Utah");
        categories.add("California");
        categories.add("Navada");

        names.add("Utah");
        names.add("California");
        names.add("Navada");
        names.add("California");
        names.add("Utah");

        values.add(2.0);
        values.add(3.0);
        values.add(4.0);
        values.add(5.0);
        values.add(6.0);
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testsummarizeData4 ()
    {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> values = new ArrayList<>();
        ArrayList<String> categories = new ArrayList<>();
        int operation = 0;
        
        categories.add("Utah");
        categories.add("California");
        categories.add("Navada");
        categories.add("California");

        names.add("Utah");
        names.add("California");
        names.add("Navada");
        names.add("California");
        names.add("Utah");

        values.add(-2.0);
        values.add(3.0);
        values.add(4.0);
        values.add(5.0);
        values.add(6.0);
        
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void testsummarizeData5 ()
    {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> values = new ArrayList<>();
        ArrayList<String> categories = new ArrayList<>();
        int operation = 5;
        
        categories.add("Utah");
        categories.add("California");
        categories.add("Navada");

        names.add("Utah");
        names.add("California");
        names.add("Navada");
        names.add("California");
        names.add("Utah");

        values.add(-2.0);
        values.add(3.0);
        values.add(4.0);
        values.add(5.0);
        values.add(6.0);
        
        
    }

    @Test
    public void testgetSum ()
    {
        ArrayList<Double> stateValues = new ArrayList<>();

        stateValues.add(8.0);
        stateValues.add(5.0);
        stateValues.add(3.0);

        double sum = GraphingMethods.getSum(stateValues);
        assertEquals(16.0, sum, 1e-6);

    }

    @Test
    public void testgetAverage ()
    {
        ArrayList<Double> stateValues = new ArrayList<>();

        stateValues.add(10.0);
        stateValues.add(5.0);
        stateValues.add(4.0);

        double Avg = GraphingMethods.getAverage(stateValues);
        assertEquals(6.333333, Avg, 1e-6);

    }

    @Test
    public void testgetMinValue ()
    {
        ArrayList<Double> stateValues = new ArrayList<>();

        stateValues.add(8.2);
        stateValues.add(10.3);
        stateValues.add(320.0);

        double min = GraphingMethods.getMinValue(stateValues);
        assertEquals(8.2, min, 1e-6);

    }

    @Test
    public void testgetMaxValue ()
    {
        ArrayList<Double> stateValues = new ArrayList<>();

        stateValues.add(30.0);
        stateValues.add(2.0);
        stateValues.add(3.3);

        double max = GraphingMethods.getMaxValue(stateValues);

        assertEquals(30.0, max, 1e-6);

    }

    @Test
    public void testgetStateValues ()
    {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> values = new ArrayList<>();
        ArrayList<String> categories = new ArrayList<>();

        categories.add("Utah");
        categories.add("California");
        categories.add("Navada");

        names.add("Utah");
        names.add("California");
        names.add("Navada");
        names.add("California");
        names.add("Utah");

        values.add(2.0);
        values.add(3.0);
        values.add(4.0);
        values.add(5.0);
        values.add(6.0);


        assertEquals(4.0, GraphingMethods.getStateValues("Navada", names, values), 1e-6);

    }

    @Test
    public void testreadTable ()
    {
        String table = "A\t4\nB\t3\nC\t66\n";
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> values = new ArrayList<>();

        GraphingMethods.readTable(new Scanner(table), names, values);
    }

}
