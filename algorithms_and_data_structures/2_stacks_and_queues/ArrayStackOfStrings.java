/*
 *
 *
 */

public class ArrayStackOfStrings {
   
   private int size = 0;
   private String[] stack;

   public ArrayStackOfStrings(int capacity) {
      stack = new String[capacity];
   }

   public boolean isEmpty() {
      return size == 0;
   }

   public void push(String item) {
      if (size == stack.length) resize(2 * stack.length);
      stack[size++] = item;
   }

   public void pop() {
      String item = stack[--size];
      stack[size] = null;
      if (size > 0 && size == stack.length/4) resize(stack.length/2);
      return item;
   }

   public void resize(int capacity) {
      String[] copy = new String[capacity];
      for (int i = 0; i < stack.length; i++) {
         copy[i] = stack[i];
      }
      stack = copy;
   }
}
