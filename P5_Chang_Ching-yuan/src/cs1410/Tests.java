package cs1410;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;
import cs1410.GraphingMethods;

public class Tests
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
}