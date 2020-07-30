/**
 * Node class
 * @author Laxmi Kandel
 * @version 1.0
 */
public class Node {

//fields
    private Node next;
    private final int data;

    /**
     * Constructor
     * @param data takes data
     * @param next takes next node
     */
    public Node(int data, Node next) {

        this.data = data;
        this.next = next;
    }

    /**
     * Get next node
     * @return node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Get data
     * @return data
     */
    public int getData() {
        return data;
    }

    /**
     * Set next node
     * @param next takes next node to assign
     */
    public void setNext(Node next) {
        this.next = next;
    }

//    /**
//     * Set next data
//     * @param data takes data to be assigned
//     */
//    public void setData(int data) {
//        this.data = data;
//    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", data=" + data +
                '}';
    }
}

