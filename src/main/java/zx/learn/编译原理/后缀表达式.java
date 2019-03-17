package zx.learn.编译原理;

import java.util.Stack;

/**
 * @Auther: 胡志新
 * @Date: 2019/3/16 20:14
 * @Description:
 */
public class 后缀表达式 {

    static char[][] operators = {
       // #   (   )   *   ·  |
        {'=','>','E','>','>','>'},  //#
        {'E','>','=','>','>','>'},  //(
        {'E','E','E','E','E','E'},  //)
        {'<','>','<','>','<','<'},  //*
        {'<','>','<','>','>','<'},  //·
        {'<','>','<','>','>','>'}   //|
    };

    static int getOperatorSub(char Opt) throws Exception{
        switch (Opt)
        {
            case '#':  return 0;
            case '(':  return 1;
            case ')':  return 2;
            case '*':  return 3;
            case '·': return 4;
            case '|':  return 5;
            default:   throw new OperatorNotFountException();
        }
    }

    static char compareOperator(char op1, char op2) throws Exception {
        return (operators[getOperatorSub(op2)][getOperatorSub(op1)]);
    }

    static boolean isOperator(char ch){
        if (ch == '(' || ch == ')' || ch == '*' || ch == '·' || ch == '|' || ch == '#' )
            return true;
        return false;
    }

    static void chuli(String zhong,int currentSubscript,Stack<Character> fuhao,StringBuffer str) throws Exception {
        switch (compareOperator(zhong.charAt(currentSubscript),fuhao.peek())){
            case '>'://入栈
                fuhao.push(zhong.charAt(currentSubscript));
                break;
            case '<'://出栈 将其拼接在结果字符串后面 再做比较
                str.append(fuhao.pop());
                chuli(zhong,currentSubscript,fuhao,str);
                break;
            case '='://出栈 下一步
                fuhao.pop();
                break;
            case 'E'://报错
                throw new IncorrectlyExpressionException();
        }
    }

    static String 中缀表达式转后缀(String zhong) throws Exception {
        StringBuffer str = new StringBuffer();
        Stack<Character> fuhao = new Stack<Character>();
        //初始化栈等信息
        fuhao.push('#');
        zhong += "#";
        //读取符号
        int currentSubscript = 0;
        while (!fuhao.empty())
        {
//            if(currentSubscript >= zhong.length())
//                break;
            if(zhong.charAt(currentSubscript) == ' ')
                currentSubscript++;
            if (isOperator(zhong.charAt(currentSubscript)))//判断是不是字符
            {//如果是运算符号
                chuli(zhong,currentSubscript,fuhao,str);
            }else {//如果不是符号
                str.append(zhong.charAt(currentSubscript));
            }
            currentSubscript++;
        }
        return str.toString();
    }

    String 添加连接符号(String biaodashi)
    {
        return "";
    }

    public static void main(String[] args) throws Exception {

        String zhong = "(a·b|c*)·a·b*";
        System.out.println(中缀表达式转后缀(zhong));
    }
}
