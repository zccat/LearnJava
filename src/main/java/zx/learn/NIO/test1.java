package zx.learn.NIO;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/6
 * Time: 13:41
 * Description:
 */
public class test1 {

    public static void main(String[] args) throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("C:\\Users\\zx\\Documents\\GitHub\\LearnJava\\src\\main\\java\\zx\\learn\\NIO\\data\\nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            System.out.println("Read: " + bytesRead);
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
