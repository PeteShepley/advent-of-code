package one;

class Policy {
  String policy;

  public Policy(String input) {
    policy = input;
  }

  public char getCharacter() {
    return policy.split(" ")[1].charAt(0);
  }

  public int getMin() {
    return Integer.parseInt(policy.split(" ")[0].split("-")[0]);
  }

  public int getMax() {
    return Integer.parseInt(policy.split(" ")[0].split("-")[1]);
  }

  public String toString() {
    return policy;
  }
}
