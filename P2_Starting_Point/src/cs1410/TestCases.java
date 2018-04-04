package cs1410;

import static org.junit.Assert.*;
import static cs1410.MethodLibrary.*;
import org.junit.Test;

public class TestCases
{
    @Test
    public void testIsCapitalized ()
    {
        assertTrue(isCapitalized("Hello"));
        assertFalse(isCapitalized("hello"));
        assertFalse(isCapitalized("0"));
        assertTrue(isCapitalized("X"));
    }

    @Test
    public void testCapitalize ()
    {
        assertEquals("X", capitalize("x"));
        assertEquals("Hello", capitalize("hello"));
        assertEquals("HElLo", capitalize("hElLo"));
        assertEquals("123ab", capitalize("123ab"));
    }

    @Test
    public void testLifeStage ()
    {
        assertEquals("baby", getLifeStage(0));
        assertEquals("baby", getLifeStage(1));
        assertEquals("child", getLifeStage(2));
        assertEquals("child", getLifeStage(10));
        assertEquals("teen", getLifeStage(13));
        assertEquals("teen", getLifeStage(16));
        assertEquals("adult", getLifeStage(21));
        assertEquals("adult", getLifeStage(60));
        assertEquals("senior", getLifeStage(70));
        assertEquals("senior", getLifeStage(80));
    }

    @Test
    public void testIsVowel ()
    {
        assertTrue(isVowel('a'));
        assertTrue(isVowel('e'));
        assertTrue(isVowel('i'));
        assertTrue(isVowel('o'));
        assertTrue(isVowel('u'));
        assertTrue(isVowel('A'));
        assertTrue(isVowel('E'));
        assertTrue(isVowel('I'));
        assertTrue(isVowel('O'));
        assertTrue(isVowel('U'));
        assertFalse(isVowel('x'));
        assertFalse(isVowel('h'));
    }

    @Test
    public void testToPigLatin ()
    {
        assertEquals("ickslay", toPigLatin("slick"));
        assertEquals("ICKSLay", toPigLatin("SLICK"));
        assertEquals("ongstray", toPigLatin("strong"));
        assertEquals("ONGSTRay", toPigLatin("STRONG"));
        assertEquals("xyzzy", toPigLatin("xyzzy"));
        assertEquals("orangeway", toPigLatin("orange"));
    }

    @Test
    public void testConvertToPigLatin ()
    {
        assertEquals("isthay isway away esttay ", convertToPigLatin("this is a test"));
        assertEquals("isthay isway away esttay ", convertToPigLatin("    this     is     a         test"));
        assertEquals("", convertToPigLatin(""));
        assertEquals("", convertToPigLatin("           "));
        assertEquals("eThay ainray inway ainSpay allsfay ainlymay inway ethay ainplay ",
                convertToPigLatin("The rain in Spain falls mainly in the plain"));
    }

    @Test
    public void testMakeRectangle ()
    {
        assertEquals("++\n++\n", makeRectangle(2, 2));
        assertEquals("+-+\n| |\n+-+\n", makeRectangle(3, 3));
        assertEquals("+--+\n|  |\n|  |\n|  |\n+--+\n", makeRectangle(5, 4));
    }

    @Test
    public void testNextHailstone ()
    {
        assertEquals(1, nextHailstone(1));
        assertEquals(16, nextHailstone(5));
        assertEquals(100, nextHailstone(33));
        assertEquals(1, nextHailstone(2));
        assertEquals(8, nextHailstone(16));
        assertEquals(1000000, nextHailstone(2000000));
    }

    @Test
    public void testHailstones ()
    {
        assertEquals("1 ", hailstones(1));
        assertEquals("16 8 4 2 1 ", hailstones(16));
        assertEquals("7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1 ", hailstones(7));
    }

    @Test
    public void testCountTokens ()
    {
        assertEquals(0, countTokens(""));
        assertEquals(3, countTokens("a b c"));
        assertEquals(4, countTokens("a b c d"));
        assertEquals(9, countTokens("The rain in Spain falls mainly in the plain"));
    }
}
