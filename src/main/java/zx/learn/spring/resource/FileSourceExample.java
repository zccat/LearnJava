package zx.learn.spring.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/8/9
 * Time: 16:29
 * Description:
 */
public class FileSourceExample {


    public static void main(String[] args) {
        try{
            String filePath = "C:\\Users\\zx\\Documents\\GitHub\\LearnJava\\src\\main\\resources\\a.txt";

            //使用系统文件路径方式加载文件。
            WritableResource res1 = new PathResource(filePath);

            //使用类路径来加载文件
            Resource res2 = new ClassPathResource("a.txt");

            //使用WritableResource的write写入资源文件
            OutputStream stream1 = res1.getOutputStream();
            stream1.write("欢迎你".getBytes());
            stream1.close();

            //使用Resource接口读取资源文件
            InputStream ins1 = res1.getInputStream();
            InputStream ins2 = res2.getInputStream();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int i ;
            while ((i = ins1.read()) != -1) {
                baos.write(i);
            }
            System.out.println(baos.toString());

            System.out.println("res1: " + res1.getFilename());
            System.out.println("res2: " + res2.getFilename());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
