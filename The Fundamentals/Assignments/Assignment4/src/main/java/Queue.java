/** 
 * @author Fredrik Lundström
 * 2021-09-14
 * This is a generic iterable circular linked list queue. It has methods such as
 * isEmpty which checks if the queue is empty by returning true/false. Size returns 
 * a value that tells how long the queue is. Peek returns the most recently added item to the queue.
 * Enqueue adds an item to the last position of the queue. Remove deletes
 * the first or last element in the queue depending on input. Insert adds
 * an element to either the first or last position in the queue depending on input.
 * Dequeue deletes the last element in the queue. toString builds a string containing 
 * all the elements of the queue. 
 * A FIFO iterator is used since this is a generalized queue.
 * Source: https://algs4.cs.princeton.edu/13stacks/
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
     * Adds the item to this queue.
     *
     * @param  item the item to add
     */
    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = first;
        if (isEmpty()){
            first = last;
            first.next = last;
        }
        else{
            oldlast.next = last;
        }
        n++;
    }
    
    /**
     * Removes the first or last element in the list
     * @param firstorlast determines if first or last should be removed
     */
    public void remove(String firstorlast){
        if(n == 0){
            throw new NoSuchElementException("Queue underflow");
        } else{
            if(firstorlast.equals("first")){
                last.next = first.next;
                first = first.next;
                n--;
            }
            if(firstorlast.equals("last")){
                n--;
                Node current = first;
                for(int i = 0; i < n-1; i++){
                    current = current.next;
                }
                last = current;
                last.next = first;
            } 
        } 
    }
    
    /**
     * 
     * @param firstOrLast
     * @param item 
     */
    public void insert(String firstOrLast, Item item){
        if(n == 0){
            enqueue(item);
        } else{
            if(firstOrLast.equals("first")){
                Node<Item> newFirst = new Node<Item>();
                newFirst.item = item;
                n++;
                newFirst.next = first;
                last.next = newFirst;
                first = newFirst;
            }
            if(firstOrLast.equals("last")){
                Node<Item> newLast = new Node<Item>();
                newLast.item = item;
                n++;
                last = newLast;
                newLast.next = first;
            } 
        }
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
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
