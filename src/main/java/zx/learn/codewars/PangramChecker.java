package zx.learn.codewars;

public class PangramChecker {

  public static void main(String[] args) {

  }

  public boolean check(String sentence){

    char[] chars = sentence.toCharArray();
    boolean[] booleans = new boolean[26];
    for (char aChar : chars) {
      if (aChar >= 'a' && aChar <= 'z') {
        booleans[aChar - 'a'] = true;
      }
      if (aChar >= 'A' && aChar <= 'Z') {
        booleans[aChar - 'A'] = true;
      }
    }
    for (boolean aBoolean : booleans) {
      if (!aBoolean) {
        return aBoolean;
      }
    }
    return true;
    //code
  }
}