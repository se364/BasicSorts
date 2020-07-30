import java.util.Arrays;
/**
 * SortingProblem class have all the methods for sorting
 * a array by diving it into user define number of groups
 * @author Laxmi kandel
 * @version 1.0
 */
public class SortingProblem {
    private final int[] array;//actual array [1,8,0,7,6,5,4.....]
    private final int[] group;//group array [1-5],[6,10],[11,15]....]
    private final Node[] groups;

    /**
     * Constructor for SortingProblem
     * @param array  takes array
     * @param groups takes array of nodes
     * @param group  takes array of thresholds
     */
    public SortingProblem(int[] array, Node[] groups, int[] group) {
        this.array = array;
        this.groups = groups;
        this.group = group;
    }

    /**
     * Find the min value form an array
     * @return min value
     */
    public int findMin() {
        int min = array[0];

        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    /**
     * Find the max value form an array
     * @return max value
     */
    public int findMax() {
        int max = array[0];

        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * Finding the thresholds (upper bound of each range of user define number of groups
     * @param min      int  takes the min value
     * @param max      int  takes the max value
     * @param elements double take the jumps
     * @return array of threshold
     */
    public int[] findHighBounds(int min, int max, double elements) {
        double storeMin = min;
        for (int j = 0; j < group.length - 1; j++) {

            storeMin = storeMin + elements;
            group[j] = (int) Math.floor(storeMin);

        }
        group[group.length - 1] = max;
        return group;
    }

    /**
     * Grouping elements and sorting them using linked list
     */
    public void groupingElements() {
        Node current;
        for (int value : array) {
            for (int i = 0; i < group.length; i++) {
                if (value <= group[i]) {
                    if (groups[i] == null) {
                        groups[i] = new Node(value, null);
                    } else {
                        current = groups[i];
                        Node tempNode = current;
                        int temp = current.getData();
                        if (temp >= value) {
                            current = new Node(value, tempNode);
                            groups[i] = current;
                            break;
                        }
                        while (current.getNext() != null && current.getNext().getData() <= value) {
                            current = current.getNext();
                        }
                        //don't forgot the pointer make sure to put the pointer
                        //inserting in the middle
                        if(current.getNext()!=null){
                            Node newNode = new Node(value, current.getNext());
                            current.setNext(newNode);
                        }
                        else {
                            Node newNode = new Node(value, null);
                            current.setNext(newNode);
                        }
                    }
                    break;
                }
            }
        }
    }

    /**
     * printing the grouped elements
     * @param elements takes groupSize
     */
    public void printingGroupedElements(double elements) {
        int indexJ = 0;
        for (int i = 0; i < groups.length; i++) {
            Node current = groups[i];

            if (i == 0) {
                System.out.print(indexJ + "[" + (group[i] - (int) (elements)) + "-" + group[i] + "]: ");
            } else {
                System.out.print(indexJ + "[" + (group[i - 1] + 1) + "-" + group[i] + "]: ");
            }
            indexJ++;
            if (current == null) {
                System.out.print("-> null ");

            } else {
                while (current.getNext() != null) {
                    System.out.print(current.getData() + " ->");
                    current = current.getNext();
                }
                System.out.print(current.getData());
            }
            System.out.println(" ");
        }
    }

    /**
     * Printing the sorted array after group them in node array in original array
     */
    public void sortedArray() {
        int indexI = 0;
        for (Node group : groups) {
            Node current = group;
            while (current != null && indexI < array.length) {
                array[indexI] = current.getData();
                indexI++;
                current = current.getNext();
            }
        }
//        System.out.println("PRINTING THE SORTED ARRAY: "+ Arrays.toString(array));
    }

    /**
     * Check to see if our array is sorted
     * @return boolean return false if our array is not sorted
     */
    public boolean hasInversions() {
        System.out.println();
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "SortingProblem{" +
                "array=" + Arrays.toString(array) +
                ", group=" + Arrays.toString(group) +
                ", groups=" + Arrays.toString(groups) +
                '}';
    }
}