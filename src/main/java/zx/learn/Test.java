package zx.learn;


import java.util.Arrays;

public class Test {

    public static void main(String args[]) {
        String[] strings = "admin^论文^禅与摩托车维修艺术.pdf".split("\\^");
        System.out.println(Arrays.toString(strings));


    }

}

