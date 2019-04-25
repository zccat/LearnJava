package zx.learn.编译原理;

import java.util.Stack;

/**
 * @Auther: 胡志新
 * @Date: 2019/3/16 20:14
 * @Description:
 */
public class 后缀表达式 {

    private static char[][] operators = {
       // #   (   )   *   ·  |
        {'=','>','E','>','>','>'},  //#
        {'E','>','=','>','>','>'},  //(
        {'E','E','E','E','E','E'},  //)
        {'<','>','<','>','<','<'},  //*
        {'<','>','<','>','>','<'},  //·
        {'<','>','<','>','>','>'}   //|
    };

    private static int getOperatorSub(char Opt) throws Exception{
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

    private static char compareOperator(char op1, char op2) throws Exception {
        return (operators[getOperatorSub(op2)][getOperatorSub(op1)]);
    }

    private static boolean isOperator(char ch){
        return  (ch == '(' || ch == ')' || ch == '*' || ch == '·' || ch == '|' || ch == '#' );
    }

    private static void chuli(String zhong,int currentSubscript,Stack<Character> fuhao,StringBuffer str) throws Exception {
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

    private static String Zhong2Hou(String zhong) throws Exception {
        StringBuffer str = new StringBuffer();
        Stack<Character> fuhao = new Stack<Character>();
        //初始化栈等信息
        fuhao.push('#');
        zhong += "#";
        //读取符号
        int currentSubscript = 0;
        while (!fuhao.empty()) {
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

    private static boolean isNeedDian(Character c1, Character c2){
        if(c1 == ')' || c1== '*' || !isOperator(c1)) {
//            System.out.print("char1");
            return  (c2 == '(' || !isOperator(c2));
        }
        return false;
    }

    private static String addPoint(String biaodashi){
        StringBuilder str = new StringBuilder();
        str.append(biaodashi.charAt(0));
        for(int i = 0;i<biaodashi.length()-1 ;i++) {
            char c1 = biaodashi.charAt(i);
            char c2 = biaodashi.charAt(i+1);
            if(isNeedDian(c1,c2)){
                str.append("·").append(c2);
            }else {
                str.append(c2);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) throws Exception {
//        String zhong = "(a·b|c*)·a·b*";
        String test = "(a|b)*c|def(g|h*)(cg|gg)*";

        long start = System.currentTimeMillis();
        StringBuffer stringBuilder = new StringBuffer();
        for (int i =0;i<1000;i++)
        {
            test+= "a";
//            System.out.println("转成后缀表达式"+Zhong2Hou(addPoint(test)));
            Zhong2Hou(addPoint(test));
        }
        long end = System.currentTimeMillis();
        System.out.println(stringBuilder);
        System.out.println("1000次总共使用时间"+(end-start)+"ms");
    }
}
