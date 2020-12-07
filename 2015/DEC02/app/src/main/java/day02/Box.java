package day02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Box {
  private final List<Integer> sides;
  private final int[] dimensions;

  public Box(String dimensions) {
    this.sides = new ArrayList<>();
    this.dimensions = Stream.of(dimensions.split("x"))
        .mapToInt(Integer::parseInt).sorted().toArray();

    calculateSides();
  }

  public int shortestPerimeter() {
    return (dimensions[0] * 2) + (dimensions[1] * 2);
  }

  public int volume() {
    return dimensions[0] * dimensions[1] * dimensions[2];
  }

  public int surface() {
    return sides.stream().reduce(0, Integer::sum);
  }

  public int smallestSide() {
    return sides.stream().reduce(Integer.MAX_VALUE, Math::min);
  }

  public String toString() {
    return String.format("Sides: %d %d %d", sides.get(0), sides.get(1), sides.get(2));
  }

  private void calculateSides() {
    addTwoSides(dimensions[0] * dimensions[1]);
    addTwoSides(dimensions[1] * dimensions[2]);
    addTwoSides(dimensions[2] * dimensions[0]);
  }

  private void addTwoSides(int area) {
    sides.add(area);
    sides.add(area);
  }
}
