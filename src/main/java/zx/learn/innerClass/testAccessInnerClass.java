package zx.learn.innerClass;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/8/14
 * Time: 9:05
 * Description: 试着访问内部类的属性
 */

class outer {
    private class inner {
        int innerInt = 29;
    }
}


public class testAccessInnerClass {

    public static void main(String[] args) {
        outer o = new outer();
//        outer.inner oi = o.new inner();
//        System.out.println(oi.innerInt);
    }


}
