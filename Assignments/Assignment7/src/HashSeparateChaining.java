/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Diego Bobrow */
import java.util.ArrayList;

public class HashSeparateChaining {

    private class Node {
        Entry entry;
        Node next;

        Node(Entry entry) {
            this.entry = entry;
        }
    }

    Node[] hashTable;
    int arraySize;
    int tableSize;
    int nodeCount;

    public HashSeparateChaining() {
        hashTable = new Node[10];
        arraySize = 10;
    }

    public int averageChain() {
        return (int) Math.round(nodeCount / (double) arraySize);
    }

    public boolean needResizing() {
        if (averageChain() < 3 || averageChain() > 5) {
            return true;
        }
        return false;
    }

    public ArrayList<Entry> copyAllEntries() {
        ArrayList<Entry> allEntries = new ArrayList<>();
        Node iterator = null;
        for (int i = 0; i < arraySize; i++) {
            if (hashTable[i] == null) {
                continue;
            }
            allEntries.add(hashTable[i].entry);
            iterator = hashTable[i].next;
            while (iterator != null) {
                allEntries.add(iterator.entry);
                iterator = iterator.next;
            }

        }
        return allEntries;
    }

    /**
     * TODO: Write a resizing method for the hash table.
     */
    private void resize() {
        ArrayList<Entry> entries = copyAllEntries();
        Node iterator = null;
        if (averageChain() > 5) {

            arraySize = (nodeCount/5)+1;
            hashTable = new Node[arraySize];
            for (Entry entry : entries) {
                put(entry.getKey(), entry.getValue());
            }
        } else if (averageChain() < 3) {
            arraySize = (nodeCount/3)-1;
            if(arraySize<=0){
                arraySize = 1;
            }
            hashTable = new Node[arraySize];
            for (Entry entry : entries) {
                put(entry.getKey(), entry.getValue());
            }
        }


    }

    /**
     * Computes the index in the hash table from a given key
     */
    private int hash(String key) {
        int hashCode = key.hashCode();
        return (hashCode & 0x7fffffff) % arraySize;
    }

    /**
     * Returns the number of entries in the hash table.
     */
    public int size() {
        return tableSize;
    }

    /**
     * Checks whether the hash table is empty
     */
    public boolean isEmpty() {
        return tableSize == 0;
    }

    /**
     * Returns the node containing the given key value if it exists in the table.
     * Otherwise, it returns a null value.
     */
    public Node findEntry(String key) {
        int index = hash(key);

        Node currentNode = hashTable[index];
        while (currentNode != null && !currentNode.entry.getKey().equals(key))
            currentNode = currentNode.next;

        return currentNode;

    }

    /**
     * Returns the integer value paired with the given key, if the key is in the table.
     * Otherwise, it returns null.
     */
    public Integer get(String key) {
        Node searchResult = findEntry(key);

        if (searchResult != null)
            return searchResult.entry.getValue();
        else
            return null;

    }

    /**
     * If the given key is not in the table, creates a new entry and adds it to the table.
     * Otherwise, it updates the value associated with the given key.
     */
    public void put(String key, Integer value) {
        Node searchResult = findEntry(key);

        if (searchResult != null) {
            searchResult.entry.setValue(value);
            return;
        }

        Entry newEntry = new Entry(key, value);
        Node newNode = new Node(newEntry);

        int index = hash(key);
        if (hashTable[index] != null)
            newNode.next = hashTable[index];

        hashTable[index] = newNode;

        nodeCount++;
        if (needResizing()) {
            resize();
        }
    }

    /**
     * Removes the entry containing the given key
     * from the table, if the key exists in the table.
     */
    public void delete(String key) {
        Node searchResult = findEntry(key);
        if (searchResult == null) {
            return;
        }

        int index = hash(key);
        if (hashTable[index] == searchResult)
            hashTable[index] = searchResult.next;
        else {
            Node currentNode = hashTable[index];
            while (currentNode.next != searchResult)
                currentNode = currentNode.next;
            currentNode.next = searchResult.next;
        }
        nodeCount--;
        if (needResizing()) {
            resize();
        }
    }

    /**
     * Produces a string representation of the table.
     */
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < arraySize; i++) {
            output += "\n (" + i + "): ";
            Node currentNode = hashTable[i];
            if (currentNode == null)
                output += currentNode + "\n";
            else {
                while (currentNode != null) {
                    output += " -> " + currentNode.entry;
                    currentNode = currentNode.next;
                }
                output += "\n";
            }
        }

        return output;

    }
}
