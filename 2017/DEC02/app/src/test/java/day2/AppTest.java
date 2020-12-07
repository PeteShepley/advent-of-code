package day2;

import static org.junit.Assert.assertEquals;


import java.net.URL;
import java.util.stream.Collectors;
import org.junit.Test;

public class AppTest {
  @Test
  public void testChecksumRowWithSingleValue() {
    assertEquals(0, App.checksum("1"));
  }

  @Test
  public void testChecksumRowWithManyValues() {
    assertEquals(0, App.checksum("123\t123"));
  }

  @Test
  public void testProcessMultipleRows() {
    assertEquals(0, App.checksum("1\n123\t123"));
  }

  @Test
  public void testInput() {
    URL resource = App.class.getClassLoader().getResource("test-input");
    String input = App.readAllLines(resource).stream().collect(Collectors.joining("\n"));
    assertEquals(18, App.checksum(input));
  }

  @Test
  public void testFindTwoEvenlyDivisibleNumbers() {
    assertEquals(2, App.evenDivisorDivision("2 3 4 5"));
  }

  @Test
  public void testSecondInput() {
    URL resource = App.class.getClassLoader().getResource("test-input2");
    String input = App.readAllLines(resource).stream().collect(Collectors.joining("\n"));
    assertEquals(9, App.evenDivisorDivision(input));
  }
}
