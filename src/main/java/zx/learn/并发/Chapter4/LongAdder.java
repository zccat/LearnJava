///*
// * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// *
// */
//
///*
// *
// *
// *
// *
// *
// * Written by Doug Lea with assistance from members of JCP JSR-166
// * Expert Group and released to the public domain, as explained at
// * http://creativecommons.org/publicdomain/zero/1.0/
// */
//
//package zx.learn.并发.Chapter4;
//import java.io.Serializable;
//import java.util.concurrent.ThreadLocalRandom;
//import java.util.concurrent.atomic.Striped64;
//import java.util.function.LongBinaryOperator;
//
///**
// * One or more variables that together maintain an initially zero
// * {@code long} sum.  When updates (method {@link #add}) are contended
// * across threads, the set of variables may grow dynamically to reduce
// * contention. Method {@link #sum} (or, equivalently, {@link
// * #longValue}) returns the current total combined across the
// * variables maintaining the sum.
// *
// * <p>This class is usually preferable to {@link AtomicLong} when
// * multiple threads update a common sum that is used for purposes such
// * as collecting statistics, not for fine-grained synchronization
// * control.  Under low update contention, the two classes have similar
// * characteristics. But under high contention, expected throughput of
// * this class is significantly higher, at the expense of higher space
// * consumption.
// *
// * <p>LongAdders can be used with a {@link
// * java.util.concurrent.ConcurrentHashMap} to maintain a scalable
// * frequency map (a form of histogram or multiset). For example, to
// * add a count to a {@code ConcurrentHashMap<String,LongAdder> freqs},
// * initializing if not already present, you can use {@code
// * freqs.computeIfAbsent(k -> new LongAdder()).increment();}
// *
// * <p>This class extends {@link Number}, but does <em>not</em> define
// * methods such as {@code equals}, {@code hashCode} and {@code
// * compareTo} because instances are expected to be mutated, and so are
// * not useful as collection keys.
// *
// * @since 1.8
// * @author Doug Lea
// */
//public class LongAdder  implements Serializable {
//    private static final long serialVersionUID = 7249069246863182397L;
//
//    /**
//     * Creates a new adder with initial sum of zero.
//     */
//    public LongAdder() {
//    }
//
//    /**
//     * Adds the given value.
//     *
//     * @param x the value to add
//     */
//    public void add(long x) {
//        Cell[] as; long b, v; int m; Cell a;
//        //判断cells是否为空，如果不为空则直接进入内层判断，
//        //否则尝试通过CAS在base上进行add操作，若CAS成功则结束，否则进入内层
//        if ((as = cells) != null || !casBase(b = base, b + x)) {
//            //记录cell上的CAS操作是否失败
//            boolean uncontended = true;
//            //判断cell 是否为空 为空则进入
//            //否则 使用 m 记录as的大小-1
//            //再计算当前线程应该访问cells数组的哪个元素
//            if (as == null || (m = as.length - 1) < 0 ||
//                (a = as[getProbe() & m]) == null ||
//                    //尝试通过 cas 替换改cell的值 如果不成功 就是线程之间冲突了 需要扩容
//                !(uncontended = a.cas(v = a.value, v + x)))
//                //如果替换不成功 即因为各种原因未加上
//                longAccumulate(x, null, uncontended);
//        }
//    }
//
//
//    final void longAccumulate(long x, LongBinaryOperator fn,
//                              boolean wasUncontended) {
//        int h;
//        if ((h = getProbe()) == 0) {
//            ThreadLocalRandom.current(); // 初始化ThreadLocalRandom 以便拿取当前线程的 PROBE（一个特征值）
//            h = getProbe();
//            wasUncontended = true; //是否冲突，如果当前线程尝试访问的cell元素与其他线程冲突，则为true
//        }
//        boolean collide = false;                // true if last slot nonempty
//        for (;;) {
//            //          cells           cell       cells的临时大小
//            Striped64.Cell[] as; Striped64.Cell a; int n; long v;
//            //如果cells 不为空 且 cells 的length大于0
//            if ((as = cells) != null && (n = as.length) > 0) {
//                //如果运算出来的下标的cell为空 则
//                if ((a = as[(n - 1) & h]) == null) {
//                    //如果cells 不 busy
//                    if (cellsBusy == 0) {       // Try to attach new Cell
//                        Striped64.Cell r = new Striped64.Cell(x);   // 创建一个值为 x 的 cell
//                        //cells 不繁忙 且获取到了 修改权限  进行扩容
//                        if (cellsBusy == 0 && casCellsBusy()) {
//                            //这个变量不知道干啥？？
//                            boolean created = false;
//                            try {               // Recheck under lock 锁定下重新检查？ 需要么？
//                                Striped64.Cell[] rs; int m, j;
//                                if ((rs = cells) != null &&
//                                        (m = rs.length) > 0 &&
//                                        rs[j = (m - 1) & h] == null) {
//                                    rs[j] = r;
//                                    created = true;
//                                }
//                            } finally {
//                                cellsBusy = 0;
//                            }
//                            if (created)
//                                break;
//                            continue;           // Slot is now non-empty
//                        }
//                    }
//                    collide = false;
//                }
//                else if (!wasUncontended)       // CAS already known to fail
//                    wasUncontended = true;      // Continue after rehash
//                else if (a.cas(v = a.value, ((fn == null) ? v + x :
//                        fn.applyAsLong(v, x))))
//                    break;
//                else if (n >= NCPU || cells != as)
//                    collide = false;            // At max size or stale
//                else if (!collide)
//                    collide = true;
//                else if (cellsBusy == 0 && casCellsBusy()) {
//                    try {
//                        if (cells == as) {      // Expand table unless stale
//                            Striped64.Cell[] rs = new Striped64.Cell[n << 1];
//                            for (int i = 0; i < n; ++i)
//                                rs[i] = as[i];
//                            cells = rs;
//                        }
//                    } finally {
//                        cellsBusy = 0;
//                    }
//                    collide = false;
//                    continue;                   // Retry with expanded table
//                }
//                h = advanceProbe(h);
//            }
//            //cell 为空 进行初始化
//            else if (cellsBusy == 0 && cells == as && casCellsBusy()) {
//                boolean init = false;
//                try {                           // Initialize table
//                    if (cells == as) {
//                        Striped64.Cell[] rs = new Striped64.Cell[2];
//                        rs[h & 1] = new Striped64.Cell(x);
//                        cells = rs;
//                        init = true;
//                    }
//                } finally {
//                    cellsBusy = 0;
//                }
//                if (init)
//                    break;
//            }
//            else if (casBase(v = base, ((fn == null) ? v + x :
//                    fn.applyAsLong(v, x))))
//                break;                          // Fall back on using base
//        }
//    }
//
//    /**
//     * Equivalent to {@code add(1)}.
//     */
//    public void increment() {
//        add(1L);
//    }
//
//    /**
//     * Equivalent to {@code add(-1)}.
//     */
//    public void decrement() {
//        add(-1L);
//    }
//
//    /**
//     * Returns the current sum.  The returned value is <em>NOT</em> an
//     * atomic snapshot; invocation in the absence of concurrent
//     * updates returns an accurate result, but concurrent updates that
//     * occur while the sum is being calculated might not be
//     * incorporated.
//     *
//     * @return the sum
//     */
//    public long sum() {
//        Cell[] as = cells; Cell a;
//        long sum = base;
//        if (as != null) {
//            for (int i = 0; i < as.length; ++i) {
//                if ((a = as[i]) != null)
//                    sum += a.value;
//            }
//        }
//        return sum;
//    }
//
//    /**
//     * Resets variables maintaining the sum to zero.  This method may
//     * be a useful alternative to creating a new adder, but is only
//     * effective if there are no concurrent updates.  Because this
//     * method is intrinsically racy, it should only be used when it is
//     * known that no threads are concurrently updating.
//     */
//    public void reset() {
//        Cell[] as = cells; Cell a;
//        base = 0L;
//        if (as != null) {
//            for (int i = 0; i < as.length; ++i) {
//                if ((a = as[i]) != null)
//                    a.value = 0L;
//            }
//        }
//    }
//
//    /**
//     * Equivalent in effect to {@link #sum} followed by {@link
//     * #reset}. This method may apply for example during quiescent
//     * points between multithreaded computations.  If there are
//     * updates concurrent with this method, the returned value is
//     * <em>not</em> guaranteed to be the final value occurring before
//     * the reset.
//     *
//     * @return the sum
//     */
//    public long sumThenReset() {
//        Cell[] as = cells; Cell a;
//        long sum = base;
//        base = 0L;
//        if (as != null) {
//            for (int i = 0; i < as.length; ++i) {
//                if ((a = as[i]) != null) {
//                    sum += a.value;
//                    a.value = 0L;
//                }
//            }
//        }
//        return sum;
//    }
//
//    /**
//     * Returns the String representation of the {@link #sum}.
//     * @return the String representation of the {@link #sum}
//     */
//    public String toString() {
//        return Long.toString(sum());
//    }
//
//    /**
//     * Equivalent to {@link #sum}.
//     *
//     * @return the sum
//     */
//    public long longValue() {
//        return sum();
//    }
//
//    /**
//     * Returns the {@link #sum} as an {@code int} after a narrowing
//     * primitive conversion.
//     */
//    public int intValue() {
//        return (int)sum();
//    }
//
//    /**
//     * Returns the {@link #sum} as a {@code float}
//     * after a widening primitive conversion.
//     */
//    public float floatValue() {
//        return (float)sum();
//    }
//
//    /**
//     * Returns the {@link #sum} as a {@code double} after a widening
//     * primitive conversion.
//     */
//    public double doubleValue() {
//        return (double)sum();
//    }
//
//    /**
//     * Serialization proxy, used to avoid reference to the non-public
//     * Striped64 superclass in serialized forms.
//     * @serial include
//     */
//    private static class SerializationProxy implements Serializable {
//        private static final long serialVersionUID = 7249069246863182397L;
//
//        /**
//         * The current value returned by sum().
//         * @serial
//         */
//        private final long value;
//
//        SerializationProxy(LongAdder a) {
//            value = a.sum();
//        }
//
//        /**
//         * Return a {@code LongAdder} object with initial state
//         * held by this proxy.
//         *
//         * @return a {@code LongAdder} object with initial state
//         * held by this proxy.
//         */
//        private Object readResolve() {
//            LongAdder a = new LongAdder();
//            a.base = value;
//            return a;
//        }
//    }
//
//    /**
//     * Returns a
//     * <a href="../../../../serialized-form.html#java.util.concurrent.atomic.LongAdder.SerializationProxy">
//     * SerializationProxy</a>
//     * representing the state of this instance.
//     *
//     * @return a {@link SerializationProxy}
//     * representing the state of this instance
//     */
//    private Object writeReplace() {
//        return new SerializationProxy(this);
//    }
//
//    /**
//     * @param s the stream
//     * @throws java.io.InvalidObjectException always
//     */
//    private void readObject(java.io.ObjectInputStream s)
//        throws java.io.InvalidObjectException {
//        throw new java.io.InvalidObjectException("Proxy required");
//    }
//
//}
