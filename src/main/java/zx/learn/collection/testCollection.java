package zx.learn.collection;

import java.io.Console;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Auther: quxue
 * @Date: 2019/2/28 15:29
 * @Description:
 */
public class testCollection {


    public static void main(String[] args) {
        String a = "1234568";
        String bb = "  abcdefgHIGKLMN   ";  //果然是UTF-16

//        System.out.println("字符串长度："+bb.length());
//        System.out.println("码点长度："+bb.codePointCount(0,bb.length()));
//        System.out.println(bb.trim());
        String[] strings = {"A","b","c","d","E"};

//        System.out.println();

        Scanner scanner = new Scanner(System.in);
        Console console = System.console();
        String userName = console.readLine("userName");
        char[] passowrd = console.readPassword("password:");

        System.out.println(System.getProperty("user.dir"));

        for(int i = 10;i>0;i--)
        {
            System.out.println(i);

        }

    }

}
