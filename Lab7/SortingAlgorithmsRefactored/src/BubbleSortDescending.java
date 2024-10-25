public class BubbleSortDescending implements SortingStrategy {
    @Override
    public short[] sort(short[] array) {
        if (array == null) {
            throw new NullPointerException("Array is null");
        }

        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        boolean swappedSomething = true;
        while (swappedSomething) {
            swappedSomething = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    swappedSomething = true;
                    short temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }
}
