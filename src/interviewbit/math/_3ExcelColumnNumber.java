package interviewbit.math;

public class _3ExcelColumnNumber {
    public int titleToNumber(String A) {
        int i = 0;
        int sum = 0;
        for (int j = A.length() - 1; j >=0; j--) {
            int number = A.charAt(j) - 'A' + 1;
            sum += number * Math.pow(26, i);
            i++;
        }
        return sum;
    }
}
