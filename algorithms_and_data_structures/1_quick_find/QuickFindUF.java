
public class QuickFindUF
{
   private int[] id;

   public QuickFindUF(int N)
   {
      id = new int[N];
      for (int i = 0; i < n; i++)
      {
         id[i] = i
      }
   }

   public void union(int p, int q)
   {
      qid = id[q]
      pid = id[p]
      for (int i = 0; i < id.length; i++)
      {
         if (id[i] == qid) id[i] = pid
      }
   }

   public boolean connected(int p, int q)
   {
      return id[p] == id[q]
   }


}
