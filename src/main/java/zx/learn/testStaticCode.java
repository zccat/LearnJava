package zx.learn;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptException;
import java.io.Reader;

public class testStaticCode implements Compilable,Cloneable {


    public static void main(String[] args) {

        System.out.println("start");

        StaticMid mid = new StaticMid();
        System.out.println(StaticAim.str);

        StaticAim nulltest = null;
        System.out.println(nulltest.str);

    }

    @Override
    public CompiledScript compile(String script) throws ScriptException {
        return null;
    }

    @Override
    public CompiledScript compile(Reader script) throws ScriptException {
        return null;
    }
}

class StaticMid {

    static {
        StaticAim.str = "changed";
        System.out.println("执行了staticMid的静态代码块");
    }

    public StaticMid() {

        System.out.println("执行了staticMid的Constructor");

    }
}

class StaticAim {

    public static String str ="this";

    public StaticAim() {
        System.out.println("执行了StaticAim的Constructor");
    }

}
