package CoreJava.Charpter6.lambda;


import javax.swing.*;
import java.sql.Time;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class lambdaTest {


    public static void main(String[] args) {
        String[] strings = {"a", "bb", "cc", "ddd", "ee", "ffffff"};

        System.out.println(Arrays.toString(strings));

        Arrays.sort(strings, (first, second) -> first.length() - second.length());
        Arrays.sort(strings, Comparator.comparing(String::length));

        System.out.println(Arrays.toString(strings));
//
//        Timer t = new Timer(1000, event -> {
//            System.out.println("The time is " + new Date());
//        });
//

        Timer t1 = new Timer(1000, event -> System.out.println(event));
        Timer t2 = new Timer(1000, System.out::println);

//        t.start();

        t1.start();

        JOptionPane.showConfirmDialog(null, "Quit Program?");

    }

}
