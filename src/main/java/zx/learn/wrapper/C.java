package zx.learn.wrapper;

// 专注于 c 功能块的处理
public class C extends AllWrapper {

    protected C(All all) {
        super(all);
    }

    @Override
    public void c() {
        System.out.println("C - c");
    }

    @Override
    public void X() {
        System.out.println("C - X");
        super.X();
    }
}