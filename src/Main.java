import solutions.Solution5ConsecutiveArray;

public class Main {

    public static void main(String[] args) {
        //consecutive([4, 2, 1, 6, 5]) = 3, [4, 5, 6]
        int[] array = new int[]{4, 2, 1, 6, 5};
        int res = Solution5ConsecutiveArray.consecutiveSet(array);
        System.out.println(res);
    }
}
