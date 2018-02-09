public class PercolationMain {
    public static void main(String args[]) {
       Percolation p = new Percolation(2);
       p.pr();
       p.pr_uf();
       p.open(2,1);
       p.pr();
       p.pr_uf();
       p.open(1,2);
       p.pr();
       p.pr_uf();
       System.out.println(p.percolates());
       p.open(2,2);
       System.out.println(p.percolates());
    }
}
