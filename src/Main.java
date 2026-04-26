public class Main {

    public static void main(String[] args) {

        Sorter     sorter     = new Sorter();
        Searcher   searcher   = new Searcher();
        Experiment experiment = new Experiment(sorter, searcher);

        experiment.runAllExperiments();

        System.out.println("\n=================================================================");
        System.out.println("                  DEMO — Array of 10 elements                  ");
        System.out.println("=================================================================");

        int[] original = sorter.generateRandomArray(10);
        System.out.print("Original array   : ");
        sorter.printArray(original);

        int[] bubbleArr = original.clone();
        sorter.basicSort(bubbleArr);
        System.out.print("After Bubble Sort: ");
        sorter.printArray(bubbleArr);

        int[] mergeArr = original.clone();
        sorter.advancedSort(mergeArr);
        System.out.print("After Merge Sort : ");
        sorter.printArray(mergeArr);

        int target = mergeArr[4];
        System.out.println("Searching for    : " + target);

        int index = searcher.search(mergeArr, target);
        if (index != -1) {
            System.out.println("Found at index   : " + index);
        } else {
            System.out.println("Result           : not found");
        }

        System.out.println("=================================================================");
    }
}