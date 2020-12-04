package one;

public class PasswordSet {
  private Policy policy;
  private String password;

  public PasswordSet(String input) {
    String[] parsedValues = input.split(":");
    this.policy = new Policy(parsedValues[0].trim());
    this.password = parsedValues[1].trim();
  }

  public Policy getPolicy() {
    return policy;
  }

  public String getPassword() {
    return password;
  }

  public boolean verify() {
    int count = countCharacterInPassword(policy.getCharacter());
    return count >= policy.getMin() && count <= policy.getMax();
  }

  private int countCharacterInPassword(char c) {
    int count = 0;
    for (int i = 0; i < password.length(); i++) {
      if (password.charAt(i) == c) {
        count++;
      }
    }
    return count;
  }
}
