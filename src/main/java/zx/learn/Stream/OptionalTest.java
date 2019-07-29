package zx.learn.Stream;




import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class OptionalTest {

    public static Optional<Double> inverse(Double x){
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static Optional<Double> squareRoot(Double x){

        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src/main/java/zx/learn/Stream/TheOldManAndTheSea.txt");
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        List<String> wordList = Arrays.asList(contents.split("\\PL+"));

        //orElse 方法 当为空的时候 会取括号中的值代替
        Optional<String> optionalValue = wordList.stream()
                .filter(s -> s.contains("fred"))
                .findFirst();
        System.out.println(optionalValue.orElse("No word")+" contains fred");

        Optional<String> optionalString = Optional.empty();
        String result = optionalString.orElse("N/A");
        System.out.println("result: " + result);

        //orElseGet 如果为空 调用括号中的方法 以它的返回值为值
        result = optionalString.orElseGet(() -> Locale.getDefault().getDisplayName());
        System.out.println("result: " + result);


        try
        {
//            如果为空 抛出异常
            result = optionalString.orElseThrow(IllegalStateException::new);
            System.out.println("result: " + result);
        }catch (Exception e){
            e.printStackTrace();
        }

//        并行流 findAny方法 可以结合Optional使用
        optionalValue = wordList.parallelStream()
                .filter(s->s.contains("every"))
                .findAny();
//      如果不为空 调用括号中的代码
        optionalValue.ifPresent(s -> System.out.println(s + " contains every"));

//        调用括号中的方法，将一种类型转换成另一种类型，例如 此例 将Optional<String> 转换成 Optional<Boolean>
        Set<String> results = new HashSet<>();
        optionalValue.ifPresent(results::add);
        Optional<Boolean> added = optionalValue.map(results::add);
        System.out.println(added);

//        这里没太看懂他想演示什么
        System.out.println(inverse(4.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(-1.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(0.0).flatMap(OptionalTest::squareRoot));


        Optional<Double> result2 = Optional.of(-4.0)
                .flatMap(OptionalTest::inverse).flatMap(OptionalTest::squareRoot);
        System.out.println(result2.orElse(0.0));

        System.out.println(Optional.of(-4.0));
        System.out.println(Optional.of(-4.0).flatMap(OptionalTest::inverse));
        System.out.println(Optional.of(-4.0).flatMap(OptionalTest::inverse).flatMap(OptionalTest::squareRoot));



    }
}
