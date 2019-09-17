package zx.learn.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FXTest{



    public static void main(String[] args) {

        List<Pair> list = new ArrayList<>();

        Pair<String> ps = new Pair<>();
        Pair<Integer> pi = new Pair<>();

        Type type = ((ParameterizedType)ps.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        System.out.println(type);
        System.out.println(pi.getClass());


    }

}

class Pair<T> {
    T x;
}