package zx.learn.Stream;


import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 这个类 罗列了如何创建一个stream
 *
 */
public class CreatingStreams {


    public static <T> void show (String title , Stream<T> stream){
        final int SIZE =10;
        List<T> firstElements = stream
                .limit(SIZE+1)
                .collect(Collectors.toList());
        System.out.println(title+": ");
        for (int i = 0; i < firstElements.size(); i++) {
            if(i > 0) System.out.print(", ");
            if(i<SIZE) System.out.print(firstElements.get(i));
            else System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src/main/java/zx/learn/Stream/TheOldManAndTheSea.txt");
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        /**
         * 如果是一个collection 直接调用它的 .stream() 方法 就能获得一个流
         * 对于数组 使用 Stream.of 方法也可以获得
         */
        Stream<String> words = Stream.of(contents.split("\\PL+"));
        show("words", words);

        Stream<String> song = Stream.of("gently", "down", "the", "stream");
        show("song", song);

        /**
         * 获得一个空的流
         */
        Stream<String> silence = Stream.empty();
        show("silence", silence);

        /**
         * 获取一个无限流 接受一个 Supplier<T> 接口
         */
        Stream<String> echos = Stream.generate(() -> "Echo");
        show("echos", echos);

        /**
         * 获取随机数的无限流
         */
        Stream<Double> randoms = Stream.generate(Math::random).peek(e->System.out.println("Out:"+e*100));
        show("randoms", randoms);

        /**
         * 无限序列 接受一个 UnaryOperation<T>
         */
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE));
        show("integers", integers);

        /**
         * Pattern 有一个 splitAsStream 方法 按照某个正则表达式来分割一个 CharSequence 对象
         */
        Stream<String> wordsAnotherWay = Pattern.compile("\\PL+").splitAsStream(contents);
        show("wordsAnotherWay", wordsAnotherWay);

        /**
         * Files.lines 方法会返回一个包含了文件中所有行的 stream
         */
        try (Stream<String > line = Files.lines(path,StandardCharsets.UTF_8)) {
            show("line",line);
        }

    }


}
