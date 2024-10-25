public class InsertionSortDescending implements SortingStrategy {
    @Override
    public short[] sort(short[] array) {
        if (array == null) {
            throw new NullPointerException("Array is null");
        }

        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        for (int i = 1; i < array.length; i++) {
            short temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] < temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }
}
