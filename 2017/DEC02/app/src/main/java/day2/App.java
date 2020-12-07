package day2;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
  public static int checksum(String spreadSheet) {
    List<String> rows = List.of(spreadSheet.split("\n"));
    return rows.stream().map(App::checksumRow).reduce(0, Integer::sum);
  }

  private static int checksumRow(String row) {
    int[] values = Stream.of(row.split("[\t ]")).mapToInt(Integer::parseInt).toArray();
    int max = Arrays.stream(values).reduce(Integer.MIN_VALUE, Math::max);
    int min = Arrays.stream(values).reduce(Integer.MAX_VALUE, Math::min);
    return max - min;
  }

  public static List<String> readAllLines(URL resource) {
    try {
      return Files.readAllLines(Paths.get(resource.getFile()));
    } catch (IOException e) {
      e.printStackTrace();
      return List.of("");
    }
  }

  public static void main(String[] args) {
    URL resource = App.class.getClassLoader().getResource("input");
    String input = readAllLines(resource).stream().collect(Collectors.joining("\n"));
    int value = checksum(input);
    System.out.printf("Checksum: %d%n", value);
    int value2 = evenDivisorDivision(input);
    System.out.printf("Division Sum: %d%n", value2);
  }

  public static int evenDivisorDivision(String input) {
    List<String> rows = List.of(input.split("\n"));
    return rows.stream().map(row -> evenlyDivide(row))
        .reduce(0, Integer::sum);
  }

  public static int evenlyDivide(String row) {
    int[] values = Stream.of(row.split("[\t ]")).mapToInt(Integer::parseInt).toArray();
    for (int first : values) {
      for (int second : values) {
        if (first != second && first % second == 0) {
          return first / second;
        }
      }
    }
    return 0;
  }
}
