package solutions.arrays;

import java.util.Arrays;

/**
 * @author Valentyn.Moliakov
 */
public class Solution13NStacks {

    public class Stacks<T> {
        int[] topOfStack;
        T[] stackData;
        int[] nextIndex;

        int nextAvailable = 0;

        public Stacks(int numStacks, int capacity) {
            this.topOfStack = new int[numStacks];
            Arrays.fill(topOfStack, -1);
            this.stackData = (T[]) new Object[capacity];
            this.nextIndex = new int[capacity];
            for (int i = 0; i < nextIndex.length - 1; i++) {
                nextIndex[i] = i + 1;
            }
            nextIndex[nextIndex.length - 1] = -1;
        }

        public void push(int stack, T value) {
            if (stack < 0 || stack >= topOfStack.length) {
                throw new IndexOutOfBoundsException();
            }
            if (nextAvailable < 0) {
                return;
            }
            int currentIndex = nextAvailable;
            nextAvailable = nextIndex[currentIndex];
            stackData[currentIndex] = value;
            nextIndex[currentIndex] = topOfStack[stack];
            topOfStack[stack] = currentIndex;
        }

        public T pop(int stack) {
            if (stack < 0 || stack >= topOfStack.length) {
                throw new IndexOutOfBoundsException();
            }
            int currentIndex = topOfStack[stack];
            if (currentIndex == -1) {
                throw new IndexOutOfBoundsException();
            } else {
                T value = stackData[currentIndex];
                topOfStack[stack] = nextIndex[currentIndex];
                nextIndex[currentIndex] = nextAvailable;
                nextAvailable = currentIndex;
                return value;
            }
        }
    }

}
