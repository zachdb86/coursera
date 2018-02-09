/*----------------------------------------------------------------
 *  Author:        Zach Bresnick
 *  Written:       12/30/2017
 *
 *  Compilation:   javac-algs4 Percolation.java
 *  Execution:     java-algs4 Percolation
 *
 *  A class to test if a site percolates
 *----------------------------------------------------------------*/

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int size;
    private final int sites;
    private int open;
    private boolean[] grid;
    private WeightedQuickUnionUF uf;

/*----------------------------------------------------------------
 * Constructor
 *----------------------------------------------------------------*/

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        size = n;
        sites = size*size;
        open = 0;
        grid = new boolean[sites];
        uf = new WeightedQuickUnionUF(sites+2);
    }

/*----------------------------------------------------------------
 * open site (row, col) if it is not open already
 *----------------------------------------------------------------*/
    public void open(int row, int col) {
        if (row <= 0 || row > size || col <= 0 || col > size) throw new IllegalArgumentException();
        int loc = location(row, col);

        if(grid[loc]) return;

        int l = col == 1 ? -1 : location(row, col-1);
        int r = col == size ? -1 : location(row, col+1);
        int u = location(row-1, col);
        int d = location(row+1, col);

        grid[loc] = true;
        open++;

        if (row == 1) uf.union(0, loc+1);
        if (row == size) uf.union(sites+1, loc+1);
        if (l >= 0 && l < sites && grid[l]) uf.union(loc+1, l+1);
        if (r >= 0 && r < sites && grid[r]) uf.union(loc+1, r+1);
        if (u >= 0 && u < sites && grid[u]) uf.union(loc + 1, u + 1);
        if (d >= 0 && d < sites && grid[d]) uf.union(loc + 1, d + 1);
    }

/*----------------------------------------------------------------
 *  is site (row, col) open?
 *----------------------------------------------------------------*/
    public boolean isOpen(int row, int col) {
        if (row <= 0 || row > size || col <= 0 || col > size) throw new IllegalArgumentException();
        return grid[location(row, col)];
    }

/*----------------------------------------------------------------
 * is site (row, col) full?
 *----------------------------------------------------------------*/
    public boolean isFull(int row, int col) {
        if (row <= 0 || row > size || col <= 0 || col > size) throw new IllegalArgumentException();
        int loc = location(row, col);
        return (uf.connected(0, loc+1));
    }

/*----------------------------------------------------------------
 * returns the number of open sites
 *----------------------------------------------------------------*/
    public int numberOfOpenSites() {
        return open;
    }

/*----------------------------------------------------------------
 * is system connected?
 *----------------------------------------------------------------*/
    public boolean percolates() {
        return uf.connected(0, sites+1);
    }

    private int location(int row, int col) {
        return size * (row - 1) + (col - 1);
    }

/*----------------------------------------------------------------
 * main
 *----------------------------------------------------------------*/
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}