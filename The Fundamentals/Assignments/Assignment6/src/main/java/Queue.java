/**
 * @author Fredrik Lundström
 * 2021-09-14
 * An ordered queue based on the queue from assignment 5. It has methods such as isEmpty which checks if
 * the queue is empty by returning true/false. Size returns a value that tells
 * how long the queue is. Peek returns the most recently added item to the queue.
 * Insert inserts/adds an item to the queue and sorts the value (integer) on insertion.
 * Delete removes the kth element of the queue. toString builds a string containing all the elements of the queue.
 */

import java.util.*;

public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;               // number of elements on queue

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty queue.
     */
    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }

    /**
     * Returns true if this queue is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns the item least recently added to this queue.
     *
     * @return the item least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }
    
    /**
     * Inserts an item (integer) 
     * @param item 
     */
    public void insert(Item item){
        Node newNode = new Node();
        Node pointer = first;
        Node next = first.next;
        
        newNode.item = item;
        if(isEmpty()){
            first = newNode;
            last = first;
            last.next = null;
            n++;
            return;
        }

        if((int)pointer.item > (int)newNode.item){
            first = newNode;
            first.next = pointer;
            return;
        }else{
            while(next != null && (int)next.item < (int)newNode.item){
                pointer = next;
                next = next.next;
            }
            pointer.next = newNode;
            newNode.next = next;
        }
        n++;
    }
    
    /**
     * Removes the kth element from the queue
     * @param k 
     */
    public void delete(int k){
        Node<Item> current = first;
        int counter = k;
        
        // Handles exceptions.
        if(isEmpty() || k > n || k < 1){
                throw new NoSuchElementException("Index is out of range.");
            }
        
        // Iterates current to the node in front of the
        // node to be removed.
        while(counter < (n - 1) & current.next != null){

            current = current.next;
            counter++;
        }
        // Special case where the first node is to be removed.
        if(k == n){
            first = current.next;
            first.next = current.next.next;
            n--;
        }
        // Handles removal of non-special cases.
        else{
            current.next = current.next.next;
            n--;
        }
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node<Item> current = first;
        s.append('[');
        for (int i = 0; i < n; i++) {
            s.append(current.item);
            current = current.next;
            if(current != first)
                s.append(',');
        }
        s.append(']');
        return s.toString();
    } 

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator()  {
        return new LinkedIterator(first);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
}

