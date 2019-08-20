package zx.learn;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/8/19
 * Time: 11:17
 * Description:
 */


/**
 * 在设计类时将一个方法指明为 final 看上去是明智的。你可能会觉得没人会覆写那个方法。有时这是对的。
 * <p>
 * 但请留意你的假设。通常来说，预见一个类如何被复用是很困难的，特别是通用类。
 * 如果将一个方法指定为 final，可能会防止其他程序员的项目中通过继承来复用你的类，而这仅仅是因为你没有想到它被以那种方式使用。
 * <p>
 * Java 标准类库就是一个很好的例子。尤其是 Java 1.0/1.1 的 Vector 类被广泛地使用，
 * 而且从效率考虑（这近乎是个幻想），如果它的所有方法没有被指定为 final，可能会更加有用。
 * 很容易想到，你可能会继承并覆写这么一个基础类，但是设计者们认为这么做不合适。有两个讽刺的原因。
 * 第一，Stack 继承自 Vector，就是说 Stack 是个 Vector，但从逻辑上来说不对。
 * 尽管如此，Java 设计者们仍然这么做，在用这种方式创建 Stack 时，他们应该意识到了 final 方法过于约束。
 * <p>
 * 第二，Vector 中的很多重要方法，比如 addElement() 和 elementAt() 方法都是同步的。
 * 在“并发编程”一章中会看同步会导致很大的执行开销，可能会抹煞 final 带来的好处。
 * 这加强了程序员永远无法正确猜到优化应该发生在何处的观点。如此笨拙的设计却出现在每个人都要使用的标准库中，太糟糕了。
 * 庆幸的是，现代 Java 容器用 ArrayList 代替了 Vector，它的行为要合理得多。
 * 不幸的是，仍然有很多新代码使用旧的集合类库，其中就包括 Vector。
 * <p>
 * Java 1.0/1.1 标准类库中另一个重要的类是 Hashtable（后来被 HashMap 取代），它不含任何 final 方法。
 * 本书中其他地方也提到，很明显不同的类是由不同的人设计的。
 * Hashtable 就比 Vector 中的方法名简洁得多，这又是一条证据。
 * 对于类库的使用者来说，这是一个本不应该如此草率的事情。
 * 这种不规则的情况造成用户需要做更多的工作——这是对粗糙的设计和代码的又一讽刺。
 */

public class kye_final {

    public static final String str;

    //    static的 可以 在 static块中给他赋值
    static {
        str = "  ";
    }

    //对于 非 static 的 final 变量，你可以在 构造函数 中给他赋值
    public kye_final() {
//        str = "new String";
    }

    public static void main(String[] args) {
        kye_final kye_final = new kye_final();
        System.out.println(kye_final.str);
    }
}
