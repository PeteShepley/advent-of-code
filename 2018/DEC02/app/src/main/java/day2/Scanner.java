package day2;

import java.util.HashMap;
import java.util.Map;

public class Scanner {
  Map<Character, Integer> counts;

  public Scanner() {
    this.counts = new HashMap<>();
  }

  public void scan(String input) {
    for (char c : input.toCharArray()) {
      if (!counts.containsKey(c)) {
        counts.put(c, 0);
      }
      counts.put(c, counts.get(c) + 1);
    }
  }

  public int getDoubleCount() {
    int doubles = 0;
    for (int value : counts.values()) {
      if (value == 2) {
        doubles += 1;
      }
    }
    return doubles;
  }

  public int getTripleCount() {
    int triples = 0;
    for (int value : counts.values()) {
      if (value == 3) {
        triples += 1;
      }
    }
    return triples;
  }
}
