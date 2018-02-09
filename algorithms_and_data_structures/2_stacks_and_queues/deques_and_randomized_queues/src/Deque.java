import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private int size;
    private Node<Item> first;
    private Node<Item> last;

    private class Node<Item> {
        Item item;
        Node<Item> prev;
        Node<Item> next;
    }

    public Deque() {
        size = 0;
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node newFirst = new Node();
        newFirst.item = item;
        newFirst.next = first;
        if(size == 0) {
            last = newFirst;
        }
        else {
            first.prev = newFirst;
        }
        first = newFirst;
        size++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node newLast = new Node();
        newLast.item = item;
        newLast.prev = last;
        if(size == 0) {
            first = newLast;
        }
        else {
            last.next = newLast;
        }
        last = newLast;
        size++;
    }
    public Item removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Item item = (Item) first.item;
        first = first.next;
        size--;
        if (first != null) {
            first.prev = null;
        }

        return item;
    }

    public Item removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Item item = (Item) last.item;
        last = last.prev;
        size--;
        if (last != null) {
            last.next = null;
        }
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        public boolean hasNext()  {
            return current != null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = (Item) current.item;
            current = current.next;
            return item;
        }
    }


    public static void main (String[] args) {
        Deque<String> dq = new Deque<String>();
        // dq.addFirst("first");
        // dq.addFirst("new first");
        dq.addLast("last");
        for (String s : dq) {
            System.out.println(s);
        }
        System.out.println(dq.size());

        String ss = dq.removeFirst();
        System.out.println("Removed first: " + ss);
        System.out.println(dq.size());
        for (String t : dq) {
            System.out.println(t);
        }
        dq.removeLast();
    }
}
