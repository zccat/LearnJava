package zx.learn.mybatis;

import org.apache.commons.io.input.XmlStreamReader;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/3
 * Time: 10:10
 * Description:
 */
public class BuilderTest {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("");
        InputStream stream = new FileInputStream(file);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
    }
}
