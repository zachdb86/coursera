/*----------------------------------------------------------------
 *  Author:        Zach Bresnick
 *  Written:       12/30/2017
 *
 *  Compilation:   javac-algs4 PercolationStats.java
 *  Execution:     java-algs4 PercolationStats size trials
 *
 *  A class measure statistics related to a percolation model
 *----------------------------------------------------------------*/

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final int size;
    private final int trials;
    private final double[] results;

/*----------------------------------------------------------------
 * Constructor
 *----------------------------------------------------------------*/
    public PercolationStats(int n, int t) {

        if (n <= 0 || t <= 0) throw new IllegalArgumentException();

        size = n;
        trials = t;
        results = new double[trials];
        Percolation[] percolations = new Percolation[trials];

        for (int i = 0; i < percolations.length; i++) {
            percolations[i] = new Percolation(size);
            while (!percolations[i].percolates()) {
                int row = 1 + StdRandom.uniform(n);
                int col = 1 + StdRandom.uniform(n);
                if (!percolations[i].isOpen(row, col)) {
                    percolations[i].open(row, col);
                }
            }
            results[i] = (double) percolations[i].numberOfOpenSites() / (size * size);
        }

    }   // perform trials independent experiments on an n-by-n grid

    /*----------------------------------------------------------------
     * sample mean of percolation threshold
     *----------------------------------------------------------------*/
    public double mean() {
        return StdStats.mean(results);
    }

    /*----------------------------------------------------------------
     * sample standard deviation of percolation threshold
     *----------------------------------------------------------------*/
    public double stddev() {
        return StdStats.stddev(results);
    }

    /*----------------------------------------------------------------
     * low  endpoint of 95% confidence interval
     *----------------------------------------------------------------*/
    public double confidenceLo() {
        return mean() - (1.96 *stddev() / Math.sqrt((double) trials));
    }

    /*----------------------------------------------------------------
     * high endpoint of 95% confidence interval
     *----------------------------------------------------------------*/
    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt((double) trials));
    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();

        PercolationStats ps = new PercolationStats(n, trials);

        System.out.println("mean                    = " + ps.mean());
        System.out.println("stddev                  = " + ps.stddev());
        System.out.println("95% confidence interval = [" + ps.confidenceLo() + ", " + ps.confidenceHi() +"]");

    }
}
