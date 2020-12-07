package day2;

public class OddKeypad implements Keypad {
  String[][] keypad = new String[][] {
      new String[] {".", ".", ".", ".", ".", ".", "."},
      new String[] {".", ".", ".", "1", ".", ".", "."},
      new String[] {".", ".", "2", "3", "4", ".", "."},
      new String[] {".", "5", "6", "7", "8", "9", "."},
      new String[] {".", ".", "A", "B", "C", ".", "."},
      new String[] {".", ".", ".", "D", ".", ".", "."},
      new String[] {".", ".", ".", ".", ".", ".", "."}
  };

  private int y = 3;
  private int x = 1;

  @Override
  public void up() {
    if (!isDot(x, y - 1)) {
      y = y - 1;
    }
  }

  @Override
  public void right() {
    if (!isDot(x + 1, y)) {
      x = x + 1;
    }
  }

  @Override
  public void down() {
    if (!isDot(x, y + 1)) {
      y = y + 1;
    }
  }

  @Override
  public void left() {
    if (!isDot(x - 1, y)) {
      x = x - 1;
    }
  }

  @Override
  public String getKey() {
    return keypad[y][x];
  }

  private boolean isDot(int x, int y) {
    return keypad[y][x].equals(".");
  }
}
