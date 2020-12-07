package two;

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
    return isFirstPosCharacter() ^ isSecondPosCharacter();
  }

  private boolean isFirstPosCharacter() {
    return password.charAt(policy.getPosOne() - 1) == policy.getCharacter();
  }

  private boolean isSecondPosCharacter() {
    return password.charAt(policy.getPosTwo() - 1) == policy.getCharacter();
  }
}
