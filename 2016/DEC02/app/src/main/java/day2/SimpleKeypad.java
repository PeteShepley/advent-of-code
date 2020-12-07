package day2;

public class SimpleKeypad implements Keypad {
  private final String[][] keypad = new String[][] {
      new String[] {"1", "2", "3"},
      new String[] {"4", "5", "6"},
      new String[] {"7", "8", "9"}
  };

  private int x = 1;
  private int y = 1;

  public void up() {
    y = y == 0 ? 0 : y - 1;
  }

  public void right() {
    x = x == 2 ? 2 : x + 1;
  }

  public void down() {
    y = y == 2 ? 2 : y + 1;
  }

  public void left() {
    x = x == 0 ? 0 : x - 1;
  }

  public String getKey() {
    return keypad[y][x];
  }
}
