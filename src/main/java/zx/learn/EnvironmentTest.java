package zx.learn;

import org.junit.Test;

import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/8/16
 * Time: 8:50
 * Description:
 */
public class EnvironmentTest {

    @Test
    public void SoutEnvir() {
        Properties properties = System.getProperties();
//        System.out.println(properties);
        for (Object o : properties.keySet()) {
            System.out.println("key: " + o + "    Value: "+properties.get(o));
        }
    }

}
