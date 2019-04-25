package zx.learn.EL;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @Auther: 胡志新
 * @Date: 2019/4/5 11:29
 * @Description:
 */
public class SpelHello {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("CC");
        user.setCredits("1133");
        user.setId(47);
        EvaluationContext context = new StandardEvaluationContext(user);
        ExpressionParser parser = new SpelExpressionParser();
        String userName = (String) parser.parseExpression("userName").getValue(context);
        System.out.println(userName);

    }
}
