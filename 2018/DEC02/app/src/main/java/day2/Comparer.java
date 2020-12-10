package day2;

import java.util.ArrayList;
import java.util.List;

public class Comparer {
  public static List<Integer> findDiffPositions(String one, String two) {
    List<Integer> diffIndicies = new ArrayList<>();
    for (int i = 0; i < one.length(); i++) {
      if (one.charAt(i) != two.charAt(i)) {
        diffIndicies.add(i);
      }
    }
    return diffIndicies;
  }

  public static String same(String one, String two) {
    StringBuilder same = new StringBuilder();

    for (int i = 0; i < one.length(); i++) {
      if (one.charAt(i) == two.charAt(i)) {
        same.append(one.charAt(i));
      }
    }

    return same.toString();
  }
}
