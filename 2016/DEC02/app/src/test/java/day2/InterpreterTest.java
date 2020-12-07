package day2;

import static org.junit.Assert.*;


import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

public class InterpreterTest {
  private Interpreter interpreter;
  private Interpreter oddInterpreter;

  @Before
  public void beforeEach() {
    interpreter = new Interpreter(new SimpleKeypad());
    oddInterpreter = new Interpreter(new OddKeypad());
  }

  @Test
  public void testNoInstruction() {
    assertEquals("5", interpreter.parse(""));
  }

  @Test
  public void testOneUpInstruction() {
    assertEquals("2", interpreter.parse("U"));
  }

  @Test
  public void testTwoUpInstructions() {
    assertEquals("2", interpreter.parse("UU"));
  }

  @Test
  public void testOneLeftInstruction() {
    assertEquals("4", interpreter.parse("L"));
  }

  @Test
  public void testTwoLeftInstructions() {
    assertEquals("4", interpreter.parse("LL"));
  }

  @Test
  public void testOneDownInstruction() {
    assertEquals("8", interpreter.parse("D"));
  }

  @Test
  public void testTwoDownInstruction() {
    assertEquals("8", interpreter.parse("DD"));
  }

  @Test
  public void testOneRightInstruction() {
    assertEquals("6", interpreter.parse("R"));
  }

  @Test
  public void testTwoRightInstruction() {
    assertEquals("6", interpreter.parse("RR"));
  }

  @Test
  public void testInput() {
    try {
      URL resource = App.class.getClassLoader().getResource("test-input");
      List<String> input = Files.readAllLines(Paths.get(resource.getFile()));
      String code = input.stream().map(line -> interpreter.parse(line)).collect(Collectors.joining());
      assertEquals("1985", code);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testInputOddInterpreter() {
    try {
      URL resource = App.class.getClassLoader().getResource("test-input");
      List<String> input = Files.readAllLines(Paths.get(resource.getFile()));
      String code = input.stream().map(line -> oddInterpreter.parse(line)).collect(Collectors.joining());
      assertEquals("5DB3", code);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}