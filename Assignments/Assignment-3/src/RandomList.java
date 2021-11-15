/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Diego Bobrow*/
public class RandomList {

    private class Node {
        int value;
        Node next;
    }

    private Node head;

    public RandomList(int bound, int size) {
        int randomValue;
        head = new Node();
        Node node = head;
        for (int i = 0; i < size; i++) {
            randomValue = (int) (Math.random() * ((int) Math.pow(10, bound)));
            if (node.next == null) {
                node.next = new Node();
                node.next.value = randomValue;
            }
            node = node.next;
        }
    }

    @Override
    public String toString() {
        String list = "";
        Node node = head.next;
        while (node != null) {
            list += node.value;
            list += " ";
            node = node.next;
        }
        return list;
    }

    public void removeAdjacentDuplicates() {
        Node previousNode = head;
        Node node = head.next;
        while (node != null) {
            if (previousNode.value == node.value) {
                previousNode.next = node.next;
            } else {
                previousNode = node;
            }
            node = node.next;
        }

    }

    public static void main(String[] args) {
        RandomList list = new RandomList(1, 100);
        System.out.println("Random list:\n" + list + "\n");
        list.removeAdjacentDuplicates();
        System.out.println("List with adjacent duplicates removed:\n" + list);
    }

}


