package zx.learn.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: 胡志新
 * @Date: 2019/4/9 15:34
 * @Description:
 */
public class testList {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<Integer>();
        for (int i = 0; i < 99; i++) {
            integers.add(i);
        }

        List<Integer> other = new ArrayList<Integer>();

//        System.arraycopy(integers,0,other,0,integers.size());

        for (Integer integer : integers) {
            other.add(new Integer(integer));
        }

        for (Integer integer : integers) {
            if (integer % 2 == 0)
                integers.remove(integer);
        }

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

}
