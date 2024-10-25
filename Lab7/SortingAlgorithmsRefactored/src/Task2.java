import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        SortContext context = new SortContext();
        context.setSortingStrategy(new BubbleSortDescending());
        System.out.println("BubbleSortDescending");
        printResults(context,new short[] {6, 7, 8, 9, 10});
        printResults(context,new short[] {10, 9, 8, 7, 6});
        printResults(context,new short[] {6, 7, 8, 7, 6});
        printResults(context,null);
        printResults(context,new short[] {});
    }

    static void printResults(SortContext context, short[] array) {
        try {
            System.out.println(Arrays.toString(context.executeSortingStrategy(array)));
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
