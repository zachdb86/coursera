/*
 *
 *
 */

public class QueueOfStrings {
   
   private Node first, last;

   private class Node {
      String data;
      Node next;
   }

   public void enqueue(String data) {
      Node oldLast = last;
      last = new Node();
      last.data = data;
      last.next = null;
      if (isEmpty()) first = last;
      else oldLast.next = last;
   }

   public String dequeue() {
      String item = first.data;
      first = first.next;
      if (isEmpty()) last = null;
      return item;
   }

   public boolean isEmpty() { return first == null; }

   public static void main(String[] args) {

   }
}
