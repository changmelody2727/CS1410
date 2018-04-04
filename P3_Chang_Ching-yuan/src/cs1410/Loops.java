package cs1410;

import java.util.Scanner;

public class Loops 
{
	/**
	 * takes a positive integer n as its parameter, 
	 * and returns an int. It returns the number of positive factors of n. 
	 */
	public static int countFactors (int n)
	{
		int fact = 0;
        int i = 1;
        while (i <= n)
        {
            if(n % i == 0)
            {
            	fact++;
            }
            i++;
        }
        return fact;
	}
	
	/**
	 * takes a String s as a parameter and returns an int. 
	 * It returns the number of whitespace characters contained in s. 
	 */
	public static int countWhitespace (String s)
	{
        int i = 0;
        int count = 0;
        while (i < s.length())
        {
        	if (Character.isWhitespace(s.charAt(i)))
        	{
        		count = count + 1;
        	}
            i = i+1;
        }
        return count;
	}
	
	/**
	 * Takes a Scanner s as a parameter and returns a double.  
	 * The Scanner is required to contain only double literals 
	 * separated by white space.  If s contains no tokens, 
	 * it returns 0. Otherwise, it returns the average length of 
	 * all the tokens in s.
	 */
	public static double averageTokenLength (Scanner s)
	{
		double sum = 0;
		double average = 0;
		int numOfWords = 0;
		while (s.hasNext())
		{
			String word = s.next();
			double totalChar = word.length();
			sum = totalChar + sum;
			numOfWords ++;
		}
		if (numOfWords > 0)
		{
		average = sum/numOfWords;
		}
		else
		{
			return 0;
		}
		return average;
	}
	
	/**
	 * Takes a String s and a String t as parameters, and returns a boolean. 
	 * It returns true if t occurs as a token within s, and returns false otherwise.
	 */
	public static boolean containsToken (String s, String t)
	{
		Scanner b = new Scanner(s);
		while (b.hasNext())
        {
            String token = b.next();
            if (token.equals(t))
            {
            	b.close();
                return true;
            }
        }
		b.close();
        return false;
    }
	
	/**
	 * takes a Scanner s and a String t as parameters, and returns a String. 
	 * It returns a line from s that contains t as a token (if such a line exists)
	 * and returns null otherwise.
	 */
	public static String findLineWithToken (Scanner s, String t)
	{
		while (s.hasNextLine())
        {
            String token = s.nextLine();
            if (containsToken(token,t))
            {
                return token;
            }
        }
        return null;
    }
	
	/**
	 * takes a String s as a parameter and returns a boolean. 
	 * It returns true if s reads the same forwards and backwards,
	 * and returns false otherwise.
	 */
	public static boolean isPalindrome (String s)
	{
		String rev = "";
        int i = 0;
        while (i < s.length())
        {
            char c = s.charAt(i);
            i = i + 1;
            rev = c + rev;
        }
        if (s.equals(rev))
        {
        	return true;
        }
        else
        {
        	return false;
        }
	}
	
	/**
	 * takes an integer n (which you may assume is greater 
	 * than 1) and returns the smallest factor of n that is 
	 * greater than 1.
	 */
	public static int findSmallestFactor (int n) 
	{
		int i = 2;
		while (n > i)
		{
			if (n % i == 0)
			{
				return i;
			}
			i++;
		}
		return n;
	}
	
	/**
	 * takes a Scanner s as its parameter and returns a String.  
	 * It returns the longest token from s that is a palindrome 
	 * (if one exists) or the empty string (otherwise).
	 */
	public static String findLongestPalindrome (Scanner s)
	{
		String bestSoFar = "";
        while (s.hasNext())
        {
            String token = s.next();
            boolean pal = isPalindrome(token);
            if (pal)
            {
            	if (token.length() > bestSoFar.length())
                {
                    bestSoFar = token;
                }
            }
            
        }
        return bestSoFar;
	}
	
	/**
	 * takes a Scanner s as its parameter and returns a String.  
	 * It returns the longest line from s (if one exists) or 
	 * null (otherwise).
	 */
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
	
	/**
	 * takes a Scanner s as its parameter and returns a String.  
	 * It returns the line from s that contains the most whitespace 
	 * (if one exists) or null (otherwise).
	 */
	public static String findMostWhitespace (Scanner s)
	{
		String bestSoFar = "";
        while (s.hasNextLine())
        {
            String token = s.nextLine();
            int n = countWhitespace (token);
            if (n > countWhitespace(bestSoFar))
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
}
