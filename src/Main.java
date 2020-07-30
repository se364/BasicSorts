import java.util.Arrays;
/**
 * Sorting Algorithms group sort (Bucket Sort)
 * Homework-3
 * @author Laxmi Kandel
 * @version 1.0
 */
public class Main {
    //Number of  groups user wants
    public static final int NUMBER = 25;
    public static final int INT = 40;

    /**
     * main method
     * @param args take command line arguments (if any)
     */
    public static void main(String[] args) {
        //high bounds array of user input number

        int[] group = new int[NUMBER];
        //Node array of user input number
        Node[] groups = new Node[NUMBER];

        //random number form 1 -100
        int[] array = new int[INT];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100 + 1);
        }
        System.out.println("Genera`ting an array of size " + INT + " with elements");
        System.out.println("THE ORIGINAL ARRAY: " + Arrays.toString(array));

        System.out.println("SORTING WITH " + NUMBER + " GROUPS");
        //instantiate SortingProblem class
        SortingProblem sort = new SortingProblem(array, groups, group);
        //Calling finding min and max method
        int max = sort.findMax();
        int min = sort.findMin();
        System.out.println("MIN AND MAX :[" + min + ", " + max + "]");

        //find the sizes of the groups
        double groupSize = (double) (max - min + 1) / NUMBER;
        System.out.println("GROUP SIZE : " + groupSize);


        //calling the method for finding thresholds
        int[] highBounds = sort.findHighBounds(min, max, groupSize);
        System.out.println("GROUP THRESHOLDS : " + Arrays.toString(highBounds));
        System.out.println();

        //Grouping elements
        sort.groupingElements();

        //calling printing grouped Elements method
        sort.printingGroupedElements(groupSize);

        System.out.println();

        sort.sortedArray();
        System.out.println("SORTED ARRAY: " + Arrays.toString(array));


        //Checking inversion
        boolean answer = sort.hasInversions();
        System.out.println("Detected inversions?: " + answer);

    }
}
