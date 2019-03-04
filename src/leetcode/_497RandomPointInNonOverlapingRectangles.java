package leetcode;

import java.util.Random;
import java.util.TreeMap;

/**
 * @author Valentyn.Moliakov
 */
public class _497RandomPointInNonOverlapingRectangles {

    private class Rectangle {
        int[] values;
        int width;
        int height;

        Rectangle(int[] values, int width, int height) {
            this.values = values.clone();
            this.width = width;
            this.height = height;
        }
    }

    private Random r;
    private TreeMap<Integer, Rectangle> map;
    private int area;

    public _497RandomPointInNonOverlapingRectangles(int[][] rects) {
        r = new Random();
        map = new TreeMap<>();
        area = 0;
        for (int[] rect : rects) {
            Rectangle rectangle = new Rectangle(rect,
                    rect[2] - rect[0] + 1,
                    rect[3] - rect[1] + 1);
            area += rectangle.width * rectangle.height;
            map.put(area, rectangle);
        }
    }

    public int[] pick() {
        int randInt = r.nextInt(area);
        int key = map.higherKey(randInt);
        Rectangle rect = map.get(key);
        int x = rect.values[0] + (key - randInt - 1) % rect.width;
        int y = rect.values[1] + (key - randInt - 1) / rect.width;
        return new int[]{x, y};
    }
}
