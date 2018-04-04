package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class FileManipulations
{
    public static void main (String[] args)
    {

        SwingUtilities.invokeLater( () -> runGUI());
    }

    public static void runGUI ()
    {
        JFileChooser chooser = new JFileChooser();
        if (JFileChooser.APPROVE_OPTION != chooser.showOpenDialog(null))
        {
            return;
        }
        File file = chooser.getSelectedFile();

        String digit = JOptionPane.showInputDialog("enter a digit from 1 to 4");
        int num = Integer.parseInt(digit);

        try (Scanner fromFile = new Scanner(file))
        {

            try
            {

                if (num == 1)
                {
                    String longestLine = findLongestLine(fromFile);
                    JOptionPane.showMessageDialog(null, "The longest line is: " + longestLine);
                }

                if (num == 2)
                {
                    String longestToken = findLongestToken(fromFile);
                    JOptionPane.showMessageDialog(null, "The longest token is: " + longestToken);
                }

                if (num == 3)
                {
                    String t = JOptionPane.showInputDialog("enter String");
                    int token = tokenOccurs(fromFile, t);
                    JOptionPane.showMessageDialog(null, "the number of times that a token t occurs is: " + token);
                }

                if (num == 4)
                {
                    String number = JOptionPane.showInputDialog("enter number of tokens");
                    int n = Integer.parseInt(number);
                    int lines = numberOfLines(fromFile, n);
                    JOptionPane.showMessageDialog(null,
                            "the number of lines that contain exactly n tokens is: " + lines);
                }
            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage() + " is not a number");

            }
            catch (IllegalArgumentException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
        catch (FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "File doesn't exist");

        }
    }

    public static String findLongestLine (Scanner s)
    {
        String bestSoFar = "";
        while (s.hasNextLine())
        {
            String token = s.nextLine();
            if (token.length() > bestSoFar.length())
            {
                bestSoFar = token;
            }
        }
        if (bestSoFar.equals(""))
        {
            return null;
        }
        else
        {
            return bestSoFar;
        }
    }

    public static String findLongestToken (Scanner s)
    {
        String bestSoFar = "";
        while (s.hasNext())
        {
            String token = s.next();
            if (token.length() > bestSoFar.length())
            {
                bestSoFar = token;
            }
        }
        if (bestSoFar.equals(""))
        {
            return null;
        }
        else
        {
            return bestSoFar;
        }
    }

    public static int tokenOccurs (Scanner s, String t)
    {
        int count = 0;
        while (s.hasNext())
        {
            String token = s.next();
            if (token.equals(t))
            {
                count++;
            }
        }
        s.close();
        return count;
    }

    public static int numberOfLines (Scanner s, int n)
    {
        int numOfWords = 0;
        int count = 0;
        while (s.hasNextLine())
        {
            numOfWords++;
        }
        if (numOfWords == n)
        {
            count++;
        }
        return count;
    }
}
