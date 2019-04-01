package interviewbit.arrays;

import java.util.Collections;
import java.util.List;

public class LargestNumber {
    public String largestNumber(final List<Integer> A) {
        Collections.sort(A, (aI, bI) -> {
            String a = aI.toString();
            String b = bI.toString();
            String ab = a + b;
            String ba = b + a;
            return ab.compareTo(ba) > 0 ? -1 : 1;
        });
        StringBuilder sb = new StringBuilder();
        for (Integer number : A) {
            sb.append(number);
        }
        while(sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
