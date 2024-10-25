public class BogoSortDescending implements SortingStrategy {
    @Override
    public short[] sort(short[] array) {
        if (array == null) {
            throw new NullPointerException("Array is null");
        }

        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        while (!isSorted(array)) {
            shuffle(array);
        }
        return array;
    }

    private boolean isSorted(short[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private void shuffle(short[] array) {
        for (int i = 0; i < array.length; i++) {
            int randomIndex = (int) (Math.random() * array.length);
            short temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }
}
