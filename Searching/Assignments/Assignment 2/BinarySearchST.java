/**
 * @author Fredrik Lundström
 * 2021-09-29
 * Source: Algorithms Fourth Edition, Robert Sedgewick Kevin Wayne
 */

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;
    public BinarySearchST(int capacity) { 
        // See Algorithm 1.1 for standard array-resizing code.
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() { 
        return N; 
    }
    
    public Value get(Key key) {
        int i = rank(key); //get index for key
        if (i < N && keys[i].compareTo(key) == 0) //if there is a value for this key return value
            return vals[i];
        else 
            return null;
    }
    
    public int rank(Key key){
        int lo = 0, hi = N-1;
        while (lo <= hi) { //Här kollar vi var nyckeln ska hamna på för index genom att jämföra den nya key med den mellersta tills vi får fram rätt position för den nya key
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) 
                hi = mid - 1;
            else if (cmp > 0) 
                lo = mid + 1;
            else 
                return mid;
        }
        return lo; 
    }
    // See page 381.

    public void put(Key key, Value val) {         
        int i = rank(key); //when adding a new key we need its index
        if (i < N && keys[i].compareTo(key) == 0) { //if there already is a key we only change the value
            vals[i] = val; 
            return; 
        }
        for (int j = N; j > i; j--) { //make way for the new key and value
            keys[j] = keys[j-1]; 
            vals[j] = vals[j-1]; 
        }
        keys[i] = key; //add the new key and value
        vals[i] = val;
        N++; //increase size
    }

    public boolean contains(Key hi) {
        return get(hi) != null;
    }

    public Key min() {
        return keys[0]; 
    }

    public Key max() { 
        return keys[N-1]; 
    }
    
    public Key select(int k) { 
        return keys[k]; 
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    public void delete(Key key) {}
    // See Exercise 3.1.16 for this method.

    /**
     * Show table and its keys with values
     */
    public void show() {
        for(int i = 0; i < this.N; i++){
            System.out.print("[" + this.keys[i] + ", " + this.vals[i] + "]");
            if(i != this.N - 1)
                System.out.print(", ");
        }
    }
}