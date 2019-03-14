package leetcode;

import java.util.Stack;

/**
 * @author Valentyn.Moliakov
 */
public class _45AddTwoNumbersII {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode curr = null, prev = null;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int val = carry;
            if (!s1.isEmpty()) {
                val += s1.pop();
            }
            if (!s2.isEmpty()) {
                val += s2.pop();
            }
            carry = val / 10;
            val %= 10;
            curr = new ListNode(val);
            curr.next = prev;
            prev = curr;
        }
        return curr;
    }
}
