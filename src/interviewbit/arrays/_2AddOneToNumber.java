package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Valentyn.Moliakov
 */
public class _2AddOneToNumber {

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int n = A.size();

        int carry = (A.get(n - 1) + 1) / 10;
        A.set(n - 1, (A.get(n - 1) + 1) % 10);
        for (int i = n - 2; i >= 0; i--) {
            int temp = (A.get(i) + carry) / 10;
            A.set(i, (A.get(i) + carry) % 10);
            carry = temp;
            if (carry == 0) {
                break;
            }
        }

        if (carry == 1) {
            A.add(0, carry);
            return A;
        } else {
            int start = 0;
            for (Integer digit : A) {
                if (digit == 0) {
                    start++;
                } else {
                    break;
                }
            }
            return new ArrayList<>(A.subList(start, n));
        }
    }

}
