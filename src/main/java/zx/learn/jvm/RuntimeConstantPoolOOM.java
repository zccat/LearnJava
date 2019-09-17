package zx.learn.jvm;


import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/16
 * Time: 14:10
 * Description:
 */
public class RuntimeConstantPoolOOM {

    public static void main(String... args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

}
