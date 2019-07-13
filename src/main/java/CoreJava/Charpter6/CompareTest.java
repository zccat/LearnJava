package CoreJava.Charpter6;

import java.util.Arrays;
import java.util.Comparator;

public class CompareTest {


    public static void main(String[] args) {
        String[] strings = {"a", "bb", "cc", "ddd", "ee", "ffffff"};

        Comparator<String> comp = new LengthComparator();

        Arrays.sort(strings,comp);

        for (String string : strings) {
            System.out.print("  "+string);
        }
    }


}


class LengthComparator implements Comparator<String> {


    @Override
    public int compare(String first, String second) {
        return second.length() - first.length();
    }
}
