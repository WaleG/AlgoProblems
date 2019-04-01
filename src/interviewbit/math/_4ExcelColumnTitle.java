package interviewbit.math;

public class _4ExcelColumnTitle {
    public String convertToTitle(int A) {
        int base = 26;
        int start = 1;
        StringBuilder sb = new StringBuilder();
        while (A != 0) {
            int rem = A % 26;
            if (rem != 0) {
                char c = (char) (rem - 1 + 'A');
                sb.insert(0, c);
                A = A / 26;
            } else {
                sb.insert(0, 'Z');
                A = A / 26 - 1;
            }
        }
        return sb.toString();
    }
}
