package zx.learn.generics;

import java.util.*;

public class GenericTest {

    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();

        name.add("icon");
        age.add(18);
        number.add(314);

        //getUperNumber(name);//1
        getUperNumber(age);//2
        getUperNumber(number);//3

        Long lll = 1000L;
        lll.intValue();//将其转换成int类型的值
        String i = "123456";
        int n = Integer.parseInt(i);
        n++;
        System.out.println("值：值：值：\b\b\b"+Math.log(Math.exp(1)));

    }

    public static void getData(List<?> data) {
        System.out.println("data :" + data.get(0));
    }

    public static void getUperNumber(List<? extends Number> data) {
        System.out.println("data :" + data.get(0));
    }
}