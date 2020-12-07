package day02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class App {
  public static List<String> readFile(String file) {
    List<String> output = new ArrayList<>();
    try {
      BufferedReader br = new BufferedReader(new FileReader(file));
      String value;
      while ((value = br.readLine()) != null) {
        output.add(value);
      }
    } catch (FileNotFoundException fnf) {
      System.out.println("Could not find file");
    } catch (IOException e) {
      System.out.println("Could not read line");
    }
    return output;
  }

  public static void main(String[] args) {
    URL inputFile = App.class.getClassLoader().getResource("input");
    List<String> boxes = readFile(inputFile.getFile());

    int totalAmountOfPaper = boxes.stream().map(Box::new)
        .mapToInt(box -> box.surface() + box.smallestSide())
        .reduce(0, Integer::sum);

    System.out.printf("Total paper: %d%n", totalAmountOfPaper);

    int totalAmountOfRibbon = boxes.stream().map(Box::new)
        .mapToInt(box -> box.shortestPerimeter() + box.volume())
        .reduce(0, Integer::sum);

    System.out.printf("Total ribbon: %d%n", totalAmountOfRibbon);
  }
}
