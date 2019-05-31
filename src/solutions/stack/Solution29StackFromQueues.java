package solutions.stack;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Valentyn.Moliakov
 */
public class Solution29StackFromQueues {
    public static class Stack<T> {
        private Queue<T> q1;
        private Queue<T> q2;

        public Stack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        // 1<-2<-3<-4<-5

        public void push(T element) {
            if (!q1.isEmpty()) {
                q2.add(q1.poll());
            }
            q1.add(element);
        }

        public T pop() {
            if (q1.isEmpty()) {
                throw new EmptyStackException();
            } else {
                T result = q1.remove();
                if (q2.isEmpty()) {
                    return result;
                } else {
                    while (q2.size() != 1) {
                        q1.add(q2.remove());
                    }
                    Queue<T> tmp = q1;
                    q1 = q2;
                    q2 = tmp;
                }
                return result;
            }
        }
    }
}
