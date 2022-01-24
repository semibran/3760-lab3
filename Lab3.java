package lab3;

import java.util.ArrayList;

public class Lab3 {

  static final int NUM_LIGHT_COLORS = 3;
  static final int NUM_PATTERNS_TO_GENERATE = 10;

  public static ArrayList<String> generateIndexList(int n) {
    ArrayList<String> patterns = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      patterns.add(Integer.toString(i));
    }
    return patterns;
  }

  public static ArrayList<String> generateAllPatterns(int n) {
    if (n == 1) {
      return generateIndexList(NUM_LIGHT_COLORS);
    }

    ArrayList<String> patterns = new ArrayList<>();
    ArrayList<String> patternsPrev = generateAllPatterns(n - 1);
    for (int i = 0; i < patternsPrev.size(); i++) {
      for (int j = 0; j < NUM_LIGHT_COLORS; j++) {
        patterns.add(patternsPrev.get(i) + Integer.toString(j));
      }
    }
    return patterns;
  }

  public static ArrayList<String> generatePatternsWithNoDoubleDigits(int n) {
    if (n == 1) {
      return generateIndexList(NUM_LIGHT_COLORS);
    }

    ArrayList<String> patterns = new ArrayList<>();
    ArrayList<String> patternsPrev = generatePatternsWithNoDoubleDigits(n - 1);
    for (int i = 0; i < patternsPrev.size(); i++) {
      String prevPattern = patternsPrev.get(i);
      char lastCharOfPrevPattern = prevPattern.charAt(prevPattern.length() - 1);
      for (int j = 0; j < NUM_LIGHT_COLORS; j++) {
        char intAsChar = Integer.toString(j).charAt(0);
        if (lastCharOfPrevPattern != intAsChar) {
          patterns.add(prevPattern + intAsChar);
        }
      }
    }
    return patterns;
  }

  public static void main(String[] args) {
    System.out.println("Generating all patterns of a given length:");
    for (int i = 1; i <= NUM_PATTERNS_TO_GENERATE; i++) {
      ArrayList<String> patterns = generateAllPatterns(i);
      System.out.println("Length " + i + " produces " + patterns.size() + " patterns.");
    }

    System.out.println("\nGenerating patterns without double digits:");
    for (int i = 1; i <= NUM_PATTERNS_TO_GENERATE; i++) {
      ArrayList<String> patterns = generatePatternsWithNoDoubleDigits(i);
      System.out.println("Length " + i + " produces " + patterns.size() + " patterns.");
    }
  }
}
