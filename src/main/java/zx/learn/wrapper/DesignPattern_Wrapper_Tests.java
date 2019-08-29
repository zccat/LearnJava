package zx.learn.wrapper;

// 单元测试
public class DesignPattern_Wrapper_Tests {

    public static void main(String[] args) {
        try {
            testname();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testname() throws Exception {
        All all = new All();
        // a
        // b
        // c
        all.a();
        all.b();
        all.c();

        all = new A(all);
        all = new B(all);
        all = new C(all);

        // A - a
        // B - b
        // C - c    
        // 可以尝试注释掉上面的某一行代码, 查看输出结果  
        all.a();
        all.b();
        all.c();

        // ----- 和上面的注入顺序正好相反
        // C - X
        // B - X
        // A - X
        // ALL - X
        all.X();        
    }

}