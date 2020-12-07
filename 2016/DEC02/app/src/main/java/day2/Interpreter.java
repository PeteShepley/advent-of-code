package day2;

public class Interpreter {
  private Keypad keypad;

  public Interpreter(Keypad keypad) {
    this.keypad = keypad;
  }

  public String parse(String instructions) {
    for (char c : instructions.toCharArray()) {
      if (c == 'U') {
        keypad.up();
      } else if (c == 'L') {
        keypad.left();
      } else if (c == 'D') {
        keypad.down();
      } else if (c == 'R') {
        keypad.right();
      }
    }

    return keypad.getKey();
  }
}
