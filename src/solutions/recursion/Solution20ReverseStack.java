package solutions.recursion;

import java.util.Stack;

/**
 * @author Valentyn.Moliakov
 */
public class Solution20ReverseStack {

    /*
    s = 1->2->3

        value = 3
        s = 1->2
            value = 2
            s = 1
                value = 1
                s empty
                    insertAtBottom(s = empty, value = 1)
                    s = 1
                insertAtBottom(s = 1, value = 2)
                temp = 1
                    insertAtBottom(s = empty, value = 2)
                    s = 2
                s = 2->1
            insertAtBottom(s = 2->1, value = 3)
     s = 3->2->1
     */

    public static Stack<Integer> reverse(Stack<Integer> stack) {
        if (stack == null) return null;
        if (stack.isEmpty()) return stack;
        Integer value = stack.pop();
        reverse(stack);
        insertAtBottom(stack, value);
        return stack;
    }

    private static void insertAtBottom(Stack<Integer> stack, Integer value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack, value);
        stack.push(temp);
    }

    /*
    stack = 1->2->3
    v1 = 3
    s = 1->2
    v2 = 2
    s = 1->

     */
}
