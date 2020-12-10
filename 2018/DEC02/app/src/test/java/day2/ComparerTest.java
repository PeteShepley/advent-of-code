package day2;

import static org.junit.Assert.*;


import org.junit.Test;

public class ComparerTest {
  @Test
  public void testCompareEmptyStrings() {
    assertArrayEquals(new Integer[] {}, Comparer.findDiffPositions("", "").toArray());
  }

  @Test
  public void testCompareSingleCharacterStrings() {
    assertArrayEquals(new Integer[] {0}, Comparer.findDiffPositions("a", "b").toArray());
  }

  @Test
  public void testCompareMultpleCharacterStrings() {
    assertArrayEquals(new Integer[] {0, 1, 2}, Comparer.findDiffPositions("abc", "xyz").toArray());
  }

  @Test
  public void testSameEmptyStrings() {
    assertEquals("", Comparer.same("", ""));
  }

  @Test
  public void testSameSimpleStrings() {
    assertEquals("a", Comparer.same("a", "a"));
  }

  @Test
  public void testSameComplexString() {
    assertEquals("fgij", Comparer.same("fghij", "fguij"));
  }
}