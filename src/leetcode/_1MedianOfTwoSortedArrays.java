package leetcode;

/**
 * @author Valentyn.Moliakov
 */
public class _1MedianOfTwoSortedArrays {

    public double median(int[] a, int[] b) {
        int X = a.length;
        int Y = b.length;

        if (X > Y) {
            return median(b, a);
        }

        int lo = 0;
        int hi = X;

        while (lo <= hi) {
            int partitionX = (lo + hi) / 2;
            int partitionY = (X + Y + 1) / 2 - partitionX;

            double maxLeftX = partitionX > 0 ? a[partitionX - 1] : Double.NEGATIVE_INFINITY;
            double minRightX = partitionX < X ? a[partitionX] : Double.POSITIVE_INFINITY;

            double maxLeftY = partitionY > 0 ? b[partitionY - 1] : Double.NEGATIVE_INFINITY;
            double minRightY = partitionY < Y ? b[partitionY] : Double.POSITIVE_INFINITY;

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((X + Y) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY){
                hi = partitionX - 1;
            } else {
                lo = partitionX + 1;
            }
        }

        return -1;
    }
}
