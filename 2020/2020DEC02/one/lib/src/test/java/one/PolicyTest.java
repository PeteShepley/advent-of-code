package one;

import static org.junit.Assert.*;


import org.junit.Test;

public class PolicyTest {
  @Test
  public void test_getPolicyCharacter() {
    Policy p = new Policy("1-3 a");
    assertEquals('a', p.getCharacter());
  }

  @Test
  public void test_getPolicyMin() {
    Policy p = new Policy("1-3 a");
    assertEquals(1, p.getMin());
  }

  @Test
  public void test_getPolicyMax() {
    Policy p = new Policy("1-3 a");
    assertEquals(3, p.getMax());
  }

}