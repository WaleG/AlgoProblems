package solutions.stack;

import java.util.Stack;

/**
 * @author Valentyn.Moliakov
 */
public class Solution28SortStacks {

    public static <T extends Comparable<T>> Stack<T> sort(Stack<T> inputStack) {
        Stack<T> tempStack = new Stack<>();
        while (!inputStack.empty()) {
            T current = inputStack.pop();
            // invariant - tempStack is always sorted in reversed order
            while (!tempStack.empty() && tempStack.peek().compareTo(current) > 0) {
                inputStack.push(tempStack.pop());
            }
            tempStack.push(current);
        }
        // push elements from tempStack to inputStack, they will be sorted according to invariant
        return tempStack;
    }

    /*
    1, 4, 3, 2 -> 1, 2, 3, 4
    s1 = 1, 2, 3, 4, 5
    t  = 6
    s2 = 6, 5, 4, 3, 2, 1
    invariant = s2 is sorted in reversed order
    if (s1.isEmpty()) {
        //push all s2 to s1 and break
    }
    int current = s1.pop();
    if (s2.isEmpty() || s2.peek() <= current) {
        s2.push(current);
    } else {
        int count
    }
     */
}
