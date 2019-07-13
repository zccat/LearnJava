package zx.learn.EL;

import lombok.Data;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @Auther: 胡志新
 * @Date: 2019/4/5 14:34
 * @Description:
 */

@Data
class User {
    int id;
    String userName;
    String credits;

    public boolean isVipMember(String userName){
        return userName.equals("cc") || userName.equals("zx") || userName.equals("mm");
    }
}

public class testCompiler {

    public static void main(String[] args) {
        User user =new User();
        //创建解析配置
        SpelParserConfiguration configuration = new SpelParserConfiguration(
                SpelCompilerMode.IMMEDIATE,
                testCompiler.class.getClassLoader());
        //创建解析器
        SpelExpressionParser parser = new SpelExpressionParser();
        //创建取值上下文
        EvaluationContext context = new StandardEvaluationContext(user);
        //表达式
        String expression = "isVipMember('cc') && isVipMember('zx')";
        //解析表达式
        SpelExpression spelExpression = parser.parseRaw(expression);
        //调用表达式求值
        System.out.println(spelExpression.getValue(context));
        System.out.println(spelExpression.getValue(context));
        System.out.println(spelExpression.getValue(context));
    }

}
