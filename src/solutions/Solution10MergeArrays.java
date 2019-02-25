package solutions;

/**
 * @author Valentyn.Moliakov
 */
public class Solution10MergeArrays {

    /*
    A = {1,3,5,0,0,0}
         ^
    B = {2,4,6}
         ^
    mergeArrays(A, B)

    A = {1,2,3,4,5,6}
           ^
    cases:
    1) a[i] <= b[j]                                            --> i++
    2) a[i] > b[j] && (j == b.length - 1 || a[i] <= b[j + 1])  --> swap(a, b, i, j) --> i++
    3) a[i] > b[j] && a[i] > b[j + 1]                          --> a[i + 1] = a[i]  --> a[i] = b[j] --> i++ --> j++

     A = {2,4,7,10,0,0,0,0}

     B = {2,3,4,8}
          ^
     A = {1,4,7,10,0,0,0,0}
                ^
     */


    public static int[] merge(int[] A, int[] B) {
        if (B.length == 0) return A;
        int i = 0;
        int j = B.length - 1;
        while(A[i + 1] >= A[i]) {
            i++;
        }
        for (int k = A.length - 1; k >= 0; k--) {
            if (j < 0) {
                A[k] = A[i--];
            } else if (i < 0) {
                A[k] = B[j--];
            } else if (B[j] > A[i]) {
                A[k] = B[j--];
            } else {
                A[k] = A[i--];
            }
        }
        return A;
    }
}
