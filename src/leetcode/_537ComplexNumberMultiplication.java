package leetcode;

/**
 * @author Valentyn.Moliakov
 */
public class _537ComplexNumberMultiplication {

    public String complexNumberMultiply(String x, String y) {
        int xPlusIndex = x.indexOf('+');
        int yPlusIndex = y.indexOf('+');

        int xA = Integer.parseInt(x.substring(0, xPlusIndex));
        int xB = Integer.parseInt(x.substring(xPlusIndex + 1, x.length() - 1));

        int yA = Integer.parseInt(y.substring(0, yPlusIndex));
        int yB = Integer.parseInt(y.substring(yPlusIndex + 1, y.length() - 1));

        int resA = xA * yA - xB * yB;
        int resB = xA * yB + xB * yA;

        return resA + "+" + resB + "i";
    }
}
