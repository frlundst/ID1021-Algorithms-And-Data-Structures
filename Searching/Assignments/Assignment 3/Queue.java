/**
 * @author Fredrik Lundström
 * 2021-09-14
 * A generic iterable First in first out(FIFO)-queue based on a double link circular list.
 * It has methods such as isEmpty which checks if the queue is empty by returning true/false.
 * Size returns a value that tells how long the queue is. Peek returns the most recently added item to the queue.
 * Enqueue adds an item to the last position of the queue. Enqueue adds an item to the last position of the queue.
 * Dequeue deletes the last element in the queue. toString builds a string containing 
 * all the elements of the queue. Iterator is FIFO-based.
 * Source: https://algs4.cs.princeton.edu/13stacks/  & Algorithms 4th edition
 */

import java.util.*;

public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of queue
    private int n;               // number of elements on queue
  
    
    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
    }

    /**
     * Initializes an empty queue.
     */
    public Queue() {
        first = null;
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
        Node<Item> newNode = new Node<Item>();
	newNode.item = item;
        newNode.next = first; 

        if (isEmpty()){
		first = newNode;
		first.next = newNode;
		first.prev = newNode;
		newNode.prev = first;		 
        }
        else{
		newNode.prev = first.prev;	
		first.prev.next = newNode;
		first.prev = newNode;
        }
        n++;
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

	if(n != 1){
		first.prev.next = first.prev;
		first = first.next;
		first.prev.next = first;
	}else{
		first = null;
	}
        n--;
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
            if(current != first){
                s.append(',');
            }
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
