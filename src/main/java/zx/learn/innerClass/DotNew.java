package zx.learn.innerClass;

// innerclasses/DotNew.java
// Creating an inner class directly using .new syntax
// 注意这里这个 .new 符号 创建内部类
public class DotNew {
    public class Inner {
        public Inner() {
            System.out.println("inner class created");;
        }
    }
    public static void main(String[] args) {
        DotNew dn = new DotNew();
//        要想直接创建内部类的对象，你不能按照你想象的方式，去引用外部类的名字 DotNew，而是必须使用外部类的对象来创建该内部类对象，就像在上面的程序中所看到的那样。
//        主要就是说，内部类是 类 的一部分，从对象创建 内部类，  不能通过 外部类.内部类 类名直接创建   外部对象名.new 内部对象构造方法()
        DotNew.Inner dni = dn.new Inner();
    }
}