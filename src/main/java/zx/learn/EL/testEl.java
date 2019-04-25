package zx.learn.EL;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 胡志新
 * @Date: 2019/4/5 14:19
 * @Description:
 */

class Simple{
    public List<Boolean> booleanList = new ArrayList<Boolean>();
}


public class testEl {

    public static void main(String[] args) {
        Simple simple = new Simple();
        simple.booleanList.add(true);
        StandardEvaluationContext context = new StandardEvaluationContext(simple);
        ExpressionParser parser = new SpelExpressionParser();
        parser.parseExpression("booleanList[0]").setValue(context,"false");
        System.out.println(simple.booleanList.get(0));
    }

}
