/* Stack of Strings
 *
 */

public class StackOfStrings {

   Private Node first = null;

   private class Node {
      String item;
      Node next;
   }

   public void push(String item) {
      Node tmp = new Node();
      tmp.item = item;
      tmp.next = first;
      first = tmp;
   }

   public String pop() {
      String item = first.item;
      first = first.next;
      return item;
   }

   public boolean isEmpty() {
      return first == null; 
   }
   
   public static void main(String[] args) {
      System.out.println("stack of strings");
   }
}
