package solutions;

/**
 * @author Valentyn.Moliakov
 */
public class Solution1MedianOfTwoArrays {

    public static double medianOfTwoArraysLinear(int[] a, int[] b) {
        int len = a.length + b.length;
        int[] aux = new int[len / 2 + 1];
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < aux.length) {
            if (i >= a.length) {
                aux[k++] = b[j++];
            } else if (j >= b.length) {
                aux[k++] = a[i++];
            } else {
                aux[k++] = a[i] >= b[j] ? b[j++] : a[i++];
            }
        }
        return (len % 2 == 0) ? (aux[aux.length - 1] + aux[aux.length - 2]) / 2.0 : aux[aux.length - 1];
    }

    public static double median(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr1.length != arr2.length) {
            throw new IllegalArgumentException();
        }
        return median(Subarray.fromArray(arr1), Subarray.fromArray(arr2));
    }

    private static double median(Subarray arr1, Subarray arr2) {
        if (arr1.getSize() == 1) {
            return (arr1.getFirst() + arr2.getFirst()) / 2.0;
        }
        if (arr1.getSize() == 2) {
            return (Math.max(arr1.getFirst(), arr2.getFirst()) +
                    Math.min(arr1.getLast(), arr2.getLast())) / 2.0;
        }
        double median1 = arr1.getMedian();
        double median2 = arr2.getMedian();
        if (median1 == median2) {
            return median1;
        }
        if (median1 > median2) {
            return median(arr1.subarray(0, arr1.getSize() / 2 + 1),
                    arr2.subarray((arr2.getSize() - 1) / 2, arr2.getSize()));
        } else {
            return median(arr1.subarray((arr1.getSize() - 1) / 2, arr1.getSize()),
                    arr2.subarray(0, arr2.getSize() / 2 + 1));
        }
    }

    private static class Subarray {
        private int[] underlying;
        private int start;
        private int size;

        private static Subarray fromArray(int[] array) {
            Subarray s = new Subarray();
            s.underlying = array;
            s.start = 0;
            s.size = array.length;
            return s;
        }

        private Subarray subarray(int i, int j) {
            if (i > j) throw new IllegalArgumentException();
            if (j > this.size) throw new IndexOutOfBoundsException();
            Subarray s = new Subarray();
            s.underlying = this.underlying;
            s.start = this.start + i;
            s.size = j - i;
            return s;
        }

        private int getSize() {
            return this.size;
        }

        private int getFirst() {
            return this.underlying[start];
        }

        private int getLast() {
            return this.underlying[start + size - 1];
        }

        private double getMedian() {
            if (this.size % 2 == 0) {
                return (underlying[start + size / 2 - 1] +
                        underlying[start + size / 2]) / 2.0;
            } else {
                return underlying[start + size / 2];
            }
        }
    }
}
