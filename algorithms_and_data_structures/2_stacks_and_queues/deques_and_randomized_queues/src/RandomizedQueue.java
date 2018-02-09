import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdIn;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] q;
    private int N;

    public RandomizedQueue() {
        q = (Item[]) new Object[4];
    } // construct an empty randomized queue

    public boolean isEmpty() {
        return N == 0;
    }                // is the randomized queue empty?

    public int size() {
        return N;
    }                       // return the number of items on the randomized queue

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (N == q.length) resize(2 * q.length);
        q[N++] = item;
    }          // add the item

    public Item dequeue() {
        if (N == 0) {
            throw new NoSuchElementException();
        }
        int loc = StdRandom.uniform(N);
        Item item = q[loc];
        q[loc] = q[--N];
        q[N] = null;
        if (N > 0 && N == q.length/4) resize(q.length/2);
        return item;
    }                   // remove and return a random item

    public Item sample() {
        if (N == 0) {
            throw new NoSuchElementException();
        }
        int loc = StdRandom.uniform(N);
        return q[loc];
    }                    // return a random item (but do not remove it)

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }        // return an independent iterator over items in random order

    private class RandomizedQueueIterator implements Iterator<Item> {

        private int i = N;
        private final int[] shuffled;

        public RandomizedQueueIterator() {
            shuffled = new int[N];
            for (int i = 0; i < N; i++) {
                shuffled[i] = i;
            }
            StdRandom.shuffle(shuffled);
        }

        public boolean hasNext()  {
            return i > 0;
        }
        public void remove() { throw new UnsupportedOperationException(); }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return q[shuffled[--i]];
        }

    }


    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = q[i];
        }
        q = copy;
    }

    public static void main(String[] args) {
        System.out.println("Optional unit testing");
    }  // unit testing (optional)
}