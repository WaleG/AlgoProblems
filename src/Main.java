import static solutions.Solution201Knapsack.*;

public class Main {

    public static void main(String[] args) {
        Item[] items = new Item[]{new Item(1, 6), new Item(2, 10), new Item(3, 12)};
        int res = bottomUpKnapsack(items, 5);
        System.out.println(res);
    }
}
