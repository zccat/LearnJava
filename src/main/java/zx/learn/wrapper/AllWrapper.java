package zx.learn.wrapper;

// Wrapper模式
public abstract class AllWrapper extends All {
    private All under;

    protected AllWrapper(All all) {
        under = all;
    }

    @Override
    public void a() {
        under.a();
    }

    @Override
    public void b() {
        under.b();
    }

    @Override
    public void c() {
        under.c();
    }

    @Override
    public void X() {
        under.X();
    }
}