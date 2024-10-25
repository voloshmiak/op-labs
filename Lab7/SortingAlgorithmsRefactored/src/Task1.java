import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        SortContext context = new SortContext();
        context.setSortingStrategy(new InsertionSortDescending());
        System.out.println("InsertionSortDescending");
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
