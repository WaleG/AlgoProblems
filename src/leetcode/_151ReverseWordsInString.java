package leetcode;

import java.util.Stack;

/**
 * @author Valentyn.Moliakov
 */
public class _151ReverseWordsInString {

    public String reverseWords(String s) {
        if (s == null) return null;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;
            int j = i;
            while (j < s.length() && s.charAt(j) != ' ') {
                j++;
            }
            stack.push(s.substring(i, j));
            i = j;
        }
        if (stack.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            if (!stack.isEmpty()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
