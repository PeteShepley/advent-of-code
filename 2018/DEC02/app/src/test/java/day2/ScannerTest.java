package day2;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

public class ScannerTest {
  Scanner scanner;

  @Before
  public void beforeEach() {
    scanner = new Scanner();
  }

  @Test
  public void testScanEmptyString() {
    scanner.scan("");
    assertEquals(0, scanner.getDoubleCount());
    assertEquals(0, scanner.getTripleCount());
  }

  @Test
  public void testScanStringWithDouble() {
    scanner.scan("aa");
    assertEquals(1, scanner.getDoubleCount());
    assertEquals(0, scanner.getTripleCount());
  }

  @Test
  public void testScanStringWithTwoDoubles() {
    scanner.scan("aabb");
    assertEquals(2, scanner.getDoubleCount());
    assertEquals(0, scanner.getTripleCount());
  }

  @Test
  public void testScanStringWithTriple() {
    scanner.scan("aaa");
    assertEquals(0, scanner.getDoubleCount());
    assertEquals(1, scanner.getTripleCount());
  }

  @Test
  public void testScanStringWithTwoTriples() {
    scanner.scan("aaabbb");
    assertEquals(0, scanner.getDoubleCount());
    assertEquals(2, scanner.getTripleCount());
  }

  @Test
  public void testScanMixedString() {
    scanner.scan("abacdbecda");
    assertEquals(3, scanner.getDoubleCount());
    assertEquals(1, scanner.getTripleCount());
  }
}
