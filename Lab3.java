package lab3;

public class Lab3 {

  public static String[] generateAllPatterns(int n) {
    if (n == 1) {
      String[] patterns = new String[3];
      for (int i = 0; i < 3; i++) {
        patterns[i] = Integer.toString(i);
      }
      return patterns;
    } else {
      String[] patterns = new String[(int) Math.pow(3, n)];
      String[] patternsPrev = generateAllPatterns(n - 1);
      for (int i = 0; i < patternsPrev.length; i++) {
        for (int j = 0; j < 3; j++) {
          patterns[i * 3 + j] = patternsPrev[i] + Integer.toString(j);
        }
      }
      return patterns;
    }
  }

  public static void main(String[] args) {
    String[] patterns = generateAllPatterns(3);
    for (int i = 0; i < patterns.length; i++) {
      System.out.println(patterns[i]);
    }
  }
}
