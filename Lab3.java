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
    }

    ArrayList<String> patterns = new ArrayList<>();
    ArrayList<String> patternsPrev = generateAllPatterns(n - 1);
    for (int i = 0; i < patternsPrev.size(); i++) {
      for (int j = 0; j < 3; j++) {
        patterns.add(patternsPrev.get(i) + Integer.toString(j));
      }
    }
    return patterns;
  }

  public static ArrayList<String> generatePatternsWithNoDoubleDigits(int n) {
    if (n == 1) {
      return generateAllPatterns(n);
    }

    ArrayList<String> patterns = new ArrayList<>();
    ArrayList<String> patternsPrev = generatePatternsWithNoDoubleDigits(n - 1);
    for (int i = 0; i < patternsPrev.size(); i++) {
      String prevPattern = patternsPrev.get(i);
      for (int j = 0; j < 3; j++) {
        char lastCharOfPrevPattern = prevPattern.charAt(prevPattern.length() - 1);
        char intAsChar = Integer.toString(j).charAt(0);
        if (lastCharOfPrevPattern != intAsChar) {
          patterns.add(prevPattern + intAsChar);
        }
      }
    }
    return patterns;
  }

  public static void main(String[] args) {
    ArrayList<String> patterns = generatePatternsWithNoDoubleDigits(3);
    System.out.println(patterns);
  }
}
