package lab3;

import java.util.ArrayList;

public class Lab3 {

  public static ArrayList<String> generateAllPatterns(int n) {
    if (n == 1) {
      ArrayList<String> patterns = new ArrayList<>();
      for (int i = 0; i < 3; i++) {
        patterns.add(Integer.toString(i));
      }
      return patterns;
    } else {
      ArrayList<String> patterns = new ArrayList<>();
      ArrayList<String> patternsPrev = generateAllPatterns(n - 1);
      for (int i = 0; i < patternsPrev.size(); i++) {
        for (int j = 0; j < 3; j++) {
          patterns.add(patternsPrev.get(i) + Integer.toString(j));
        }
      }
      return patterns;
    }
  }

  public static void main(String[] args) {
    ArrayList<String> patterns = generateAllPatterns(3);
    System.out.println(patterns);
  }
}
