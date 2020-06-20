package zx.learn.codewars;

import static org.junit.Assert.assertEquals;

public class DuplicateEncoder {

    public static void main(String[] args) {
        assertEquals(")()())()(()()(",
                DuplicateEncoder.encode("Prespecialized"));
    }

    static String encode(String word) {
        int temp[] = new int[27];

        String str = word.toLowerCase();
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            temp[c - 'a']++;
        }
        for (char c : str.toCharArray()) {
            if (temp[c - 'a'] > 1) {
                result.append(')');
            } else {
                result.append('(');
            }
        }
        return result.toString();
    }
}
