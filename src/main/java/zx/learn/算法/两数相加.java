package zx.learn.算法;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/5
 * Time: 8:23
 * Description:
 */
public class 两数相加 {

    public static void main(String[] args) {
        ListNode l1; ListNode l2;
        l1 = new ListNode(0);
//        l1.next = new ListNode(0);
//        l1.next.next = new ListNode(3);
        l2 = new ListNode(0);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        两数相加 m = new 两数相加();
        ListNode res = m.addTwoNumbers(l1, l2);
        m.show(res);

    }

    public void show(ListNode listNode) {
        ListNode l = listNode;
        while (true) {
            if (l == null) {
                return;
            }
            System.out.print(l.val );
            if (l.next != null) {
                System.out.print( " --> ");
            }
            l = l.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ptr = new ListNode(0);
        ListNode result = ptr;
        int flag = 0;
        while (true) {
            int v = l1.val + l2.val + flag;
            flag = 0;
            if (v >= 10) {
                v -= 10;
                flag = 1;
            }
            ptr.val = v;

            l1 = l1.next;
            l2 = l2.next;

            if (l1 == null && l2 == null) {
                if (flag != 1)  {
                    return result;
                }
            }

            if (l1 == null || l2 == null) {
                if (l1 == null) {
                    l1 = new ListNode(0);
                }
                if (l2 == null){
                    l2 = new ListNode(0);
                }
            }

            ptr.next = new ListNode(0);
            ptr = ptr.next;
        }

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}