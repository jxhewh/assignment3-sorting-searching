import java.util.Arrays;

public class Experiment {

    private Sorter   sorter;
    private Searcher searcher;

    public Experiment(Sorter sorter, Searcher searcher) {
        this.sorter   = sorter;
        this.searcher = searcher;
    }

    public long measureSortTime(int[] arr, String type) {
        if (!type.equalsIgnoreCase("basic") && !type.equalsIgnoreCase("advanced")) {
            System.out.println("  [ERROR] Unknown sort type: " + type);
            return -1;
        }

        int[] copy = Arrays.copyOf(arr, arr.length);

        long startTime = System.nanoTime();

        if (type.equalsIgnoreCase("basic")) {
            sorter.basicSort(copy);
        } else {
            sorter.advancedSort(copy);
        }

        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    public long measureSearchTime(int[] arr, int target) {
        long startTime = System.nanoTime();

        int result = searcher.search(arr, target);

        long endTime = System.nanoTime();

        if (result == -1) {
            System.out.println("    Target " + target + " -> not found.");
        } else {
            System.out.println("    Target " + target + " -> found at index " + result + ".");
        }

        return endTime - startTime;
    }

    public void runAllExperiments() {
        int[]    sizes      = {10, 100, 1000};
        String[] sizeLabels = {"Small (10 elements)", "Medium (100 elements)", "Large (1000 elements)"};

        System.out.println("=================================================================");
        System.out.println("          ALGORITHM PERFORMANCE EXPERIMENT RESULTS               ");
        System.out.println("=================================================================");

        for (int s = 0; s < sizes.length; s++) {
            int    size  = sizes[s];
            String label = sizeLabels[s];

            System.out.println("\n-----------------------------------------------------------------");
            System.out.println("  ARRAY SIZE: " + label);
            System.out.println("-----------------------------------------------------------------");

            int[] randomArr = sorter.generateRandomArray(size);
            int[] sortedArr = Arrays.copyOf(randomArr, randomArr.length);
            Arrays.sort(sortedArr);

            if (size <= 10) {
                System.out.print("  Random array : ");
                sorter.printArray(randomArr);
                System.out.print("  Sorted array : ");
                sorter.printArray(sortedArr);
            }

            System.out.println("\n  [ Bubble Sort ]");
            long bubbleRandom = measureSortTime(randomArr, "basic");
            System.out.println("    Random input : " + bubbleRandom + " ns");
            long bubbleSorted = measureSortTime(sortedArr, "basic");
            System.out.println("    Sorted input : " + bubbleSorted + " ns");

            System.out.println("\n  [ Merge Sort ]");
            long mergeRandom = measureSortTime(randomArr, "advanced");
            System.out.println("    Random input : " + mergeRandom + " ns");
            long mergeSorted = measureSortTime(sortedArr, "advanced");
            System.out.println("    Sorted input : " + mergeSorted + " ns");

            System.out.println("\n  [ Binary Search ] (on sorted array)");
            int existingTarget = sortedArr[size / 2];
            int missingTarget  = -1;

            System.out.println("    Searching for existing value (" + existingTarget + "):");
            long searchFound = measureSearchTime(sortedArr, existingTarget);
            System.out.println("    Time: " + searchFound + " ns");

            System.out.println("    Searching for missing value (" + missingTarget + "):");
            long searchMissing = measureSearchTime(sortedArr, missingTarget);
            System.out.println("    Time: " + searchMissing + " ns");
        }

        System.out.println("\n=================================================================");
        System.out.println("                     EXPERIMENT COMPLETE                        ");
        System.out.println("=================================================================");
    }
}