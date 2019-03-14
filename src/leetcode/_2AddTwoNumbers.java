package leetcode;

public class _2AddTwoNumbers {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(-1), root = p;
        int carry = 0;
        while (true) {
            int val = carry;
            if (l1 != null) val += l1.val;
            if (l2 != null) val += l2.val;
            carry = val / 10;
            val %= 10;
            if (carry == 0 &&
                    l1 == null &&
                    l2 == null &&
                    val == 0) {
                break;
            }
            ListNode curr = new ListNode(val);
            p.next = curr;
            p = curr;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return root.next;
    }
}
