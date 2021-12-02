package DEC02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
  private static String[] TEST_INPUT = new String[] {
      "forward 5",
      "down 5",
      "forward 8",
      "up 3",
      "down 8",
      "forward 2",
  };

  private static Position submarine = new Position();

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

  public static String[] getTokens(String command) {
    return command.split(" ");
  }

  public static void main(String[] args) {
//    List<String> input = Arrays.asList(TEST_INPUT);
    URL inputUrl = App.class.getClassLoader().getResource("input");
    List<String> input = readFile(inputUrl.getFile());

    input.stream()
        .map(App::getTokens)
        .forEach(strings -> {
          if (strings[0].equals("forward")) {
            submarine.moveForward(Integer.parseInt(strings[1]));
          } else if (strings[0].equals("up")) {
            submarine.moveUp(Integer.parseInt(strings[1]));
          } else if (strings[0].equals("down")) {
            submarine.moveDown(Integer.parseInt(strings[1]));
          }
        });

    System.out.println(submarine);
  }
}
