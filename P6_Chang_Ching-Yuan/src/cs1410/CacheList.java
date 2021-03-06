package cs1410;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * A CacheList is a collection of Cache objects together with these six constraints:
 * 
 * <ol>
 * <li>A title constraint</li>
 * <li>An owner constraint</li>
 * <li>A minimum difficulty constraint</li>
 * <li>A maximum difficulty constraint</li>
 * <li>A minimum terrain constraint</li>
 * <li>A maximum terrain constraint</li>
 * </ol>
 */
public class CacheList
{
    // The caches being managed by this CacheList. They are arranged in
    // ascending order according to cache title.
    private ArrayList<Cache> allCaches;

    // TODO: Put remainder of representation here
    private String TitleConstraint;
    private String OwnerConstraint;
    private double MaxDifficultyConstraint;
    private double MinDifficultyConstraint;
    private double MaxTerrainConstraint;
    private double MinTerrainConstraint;

    /**
     * Creates a CacheList from the specified Scanner. Each line of the Scanner should contain the description of a
     * cache in a format suitable for consumption by the Cache constructor. The resulting CacheList should contain one
     * Cache object corresponding to each line of the Scanner.
     * 
     * Sets the initial value of the title and owner constraints to the empty string, sets the minimum difficulty and
     * terrain constraints to 1.0, and sets the maximum difficulty and terrain constraints to 5.0.
     * 
     * Throws an IOException if the Scanner throws an IOException, or an IllegalArgumentException if any of the
     * individual lines are not appropriate for the Cache constructor.
     * 
     * When an IllegalArgumentException e is thrown, e.getMessage() is the number of the line that was being read when
     * the error that triggered the exception was encountered. Lines are numbered beginning with 1.
     */
    public CacheList (Scanner caches) throws IOException
    {

        // TODO: Complete this implementation
        allCaches = new ArrayList<Cache>();
        int line = 1;
        try
        {
            while (caches.hasNextLine())
            {
                Cache c = new Cache(caches.nextLine());
                allCaches.add(c);
                line++;
            }
        }
        catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("" + line);
        }

        // Sort the list of caches
        Collections.sort(allCaches, (c1, c2) -> c1.getTitle().compareToIgnoreCase(c2.getTitle()));

        TitleConstraint = "";
        OwnerConstraint = "";
        MaxDifficultyConstraint = 5;
        MaxTerrainConstraint = 5;
        MinDifficultyConstraint = 1;
        MinTerrainConstraint = 1;
    }

    /**
     * Sets the title constraint to the specified value.
     */
    public void setTitleConstraint (String title)
    {
        TitleConstraint = title;
    }

    /**
     * Sets the owner constraint to the specified value.
     */
    public void setOwnerConstraint (String owner)
    {
        OwnerConstraint = owner;
    }

    /**
     * Sets the minimum and maximum difficulty constraints to the specified values.
     */
    public void setDifficultyConstraints (double min, double max)
    {
        MinDifficultyConstraint = min;
        MaxDifficultyConstraint = max;

    }

    /**
     * Sets the minimum and maximum terrain constraints to the specified values.
     */
    public void setTerrainConstraints (double min, double max)
    {
        MaxTerrainConstraint = max;
        MinTerrainConstraint = min;

    }

    /**
     * Returns a list that contains each cache c from the CacheList so long as c's title contains the title constraint
     * as a substring, c's owner equals the owner constraint (unless the owner constraint is empty), c's difficulty
     * rating is between the minimum and maximum difficulties (inclusive), and c's terrain rating is between the minimum
     * and maximum terrains (inclusive). Both the title constraint and the owner constraint are case insensitive.
     * 
     * The returned list is arranged in ascending order by cache title.
     */
    public ArrayList<Cache> select ()
    {
        // TODO: Complete this implementation
        ArrayList<Cache> caches = new ArrayList<Cache>();
        for (int i = 0; i < allCaches.size(); i++)
        {
            Cache c = allCaches.get(i);
            if (c.getTitle().toUpperCase().contains(TitleConstraint.toUpperCase())
                    && (c.getOwner().toUpperCase().equals(OwnerConstraint.toUpperCase()) || OwnerConstraint.isEmpty())
                    && c.getDifficulty() >= MinDifficultyConstraint && c.getDifficulty() <= MaxDifficultyConstraint
                    && c.getTerrain() >= MinTerrainConstraint && c.getTerrain() <= MaxTerrainConstraint)
            {
                caches.add(c);

            }

        }
        return caches;
    }

    /**
     * Returns a list containing all the owners of all of the Cache objects in this CacheList. There are no duplicates.
     * The list is arranged in ascending order.
     */
    public ArrayList<String> getOwners ()
    {
        // TODO: Complete this implementation
        ArrayList<String> owners = new ArrayList<String>();
        for (int i = 0; i < allCaches.size(); i++)
        {
            Cache c = allCaches.get(i);
            if (!owners.contains(c.getOwner()))
            {
                owners.add(c.getOwner());

            }
        }

        // Sort the list of owners
        Collections.sort(owners, (s1, s2) -> s1.compareToIgnoreCase(s2));
        return owners;
    }
}
