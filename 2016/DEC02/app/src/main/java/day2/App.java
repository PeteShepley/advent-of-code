/*
 * This Java source file was generated by the Gradle 'init' task.
 */

package day2;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class App {
  public static void main(String[] args) {
    try {
      URL resource = App.class.getClassLoader().getResource("input");
      List<String> input = Files.readAllLines(Paths.get(resource.getFile()));
      Interpreter interpreter = new Interpreter(new SimpleKeypad());
      String code = input.stream()
          .map(line -> interpreter.parse(line)).collect(Collectors.joining());
      System.out.printf("Code is %s%n", code);

      Interpreter oddInterpreter = new Interpreter(new OddKeypad());
      String oddCode = input.stream()
          .map(line -> oddInterpreter.parse(line)).collect(Collectors.joining());
      System.out.printf("Odd Code is %s%n", oddCode);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
