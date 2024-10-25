public class SortContext {
    SortingStrategy sortingStrategy;

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public short[] executeSortingStrategy(short[] array) {
        return sortingStrategy.sort(array);
    }
}
