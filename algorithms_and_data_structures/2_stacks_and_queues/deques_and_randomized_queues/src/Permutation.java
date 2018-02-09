import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {
        int c = Integer.parseInt(args[0]);

        RandomizedQueue<String> rq = new RandomizedQueue<String>();

        while (!StdIn.isEmpty()) {

            String s = StdIn.readString();
            rq.enqueue(s);
        }

        for (int i = 0; i < c; i++) {
            System.out.println(rq.dequeue());
        }
    }

}
