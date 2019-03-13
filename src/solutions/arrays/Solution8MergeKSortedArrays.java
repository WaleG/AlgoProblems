package solutions.arrays;

import java.util.PriorityQueue;

/**
 * @author Valentyn.Moliakov
 */
public class Solution8MergeKSortedArrays {

    private class QueueNode implements Comparable<QueueNode> {
        int array;
        int index;
        int value;

        public QueueNode(int array, int index, int value) {
            this.array = array;
            this.index = index;
            this.value = value;
        }


        @Override
        public int compareTo(QueueNode o) {
            return Integer.compare(value, o.value);
        }
    }

    public int[] merge(int[][] arrays) {
        PriorityQueue<QueueNode> pq = new PriorityQueue<>();
        int size = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                size += arrays[i].length;
                pq.add(new QueueNode(i, 0, arrays[i][0]));
            }
        }
        int[] result = new int[size];
        for (int i = 0; !pq.isEmpty(); i++) {
            QueueNode n = pq.poll();
            result[i] = n.value;
            int newIndex = n.index + 1;
            if (newIndex < arrays[n.array].length) {
                pq.add(new QueueNode(n.array, newIndex, arrays[n.array][newIndex]));
            }
        }
        return result;
    }
}
