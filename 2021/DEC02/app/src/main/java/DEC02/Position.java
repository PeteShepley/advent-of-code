package DEC02;

public class Position {
  private int x;
  private int depth;
  private int aim;

  public void moveForward(int count) {
    x += count;
    depth += (count * aim);
  }

  public void moveUp(int count) {
    aim -= count;
  }

  public void moveDown(int count) {
    aim += count;
  }

  public int sum() {
    return x * depth;
  }

  public String toString() {
    return String.format("Position: %d Depth: %d Result: %d", x, depth, sum());
  }
}
