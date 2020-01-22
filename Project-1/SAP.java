import java.util.ArrayList;
import java.util.Iterator;
 import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
 import edu.princeton.cs.algs4.Digraph;
// import edu.princeton.cs.algs4.StdIn;
// import edu.princeton.cs.algs4.StdOut;
// import edu.princeton.cs.algs4.In;

public class SAP {
    private final Digraph D;
    private int Shortest;
    private int ShortAns;
    public SAP(Digraph D){
        this.D = D;
    }
    public int length(int V, int W) {
        BreadthFirstDirectedPaths bfd1 = new BreadthFirstDirectedPaths(D,V);
        BreadthFirstDirectedPaths bfd2 = new BreadthFirstDirectedPaths(D,W);
        Shortest = Integer.MAX_VALUE;
        int length = 0;
        ShortAns = -1;
        int i = 0;
        while(i < D.V()) {
            if(bfd1.hasPathTo(i) && bfd2.hasPathTo(i)) {
                length = bfd1.distTo(i) + bfd2.distTo(i); 
                if(length < Shortest) {
                    Shortest = length;
                    ShortAns = i;
                }
            }
            i++;
        }
        if(Shortest == Integer.MAX_VALUE) {
            Shortest = -1;
        }
        return Shortest;
    }
    public int ancestor(int V, int W) {
        length(V, W);
        return ShortAns;
    }
    public int length(Iterable<Integer> V, Iterable<Integer> W) {
        BreadthFirstDirectedPaths bfd1 = new BreadthFirstDirectedPaths(D , V);
        BreadthFirstDirectedPaths bfd2 = new BreadthFirstDirectedPaths(D , W);
        Shortest = Integer.MAX_VALUE;
        ShortAns = -1;
        int temp = Integer.MAX_VALUE;
        for(int i = 0; i< D.V(); i++){
            if(bfd1.hasPathTo(i) && bfd2.hasPathTo(i) && bfd1.distTo(i) + bfd2.distTo(i) < temp) {
                ShortAns = i;
                temp = bfd1.distTo(i) + bfd2.distTo(i);
            }
        }
        if(temp == Integer.MAX_VALUE) {
            temp = -1;
        }
        Shortest = temp;
        return Shortest;
    }
    public int ancestor(Iterable<Integer> V, Iterable<Integer> W) {
        length(V , W);
        return Shortest;
    }
    // public static void main(String[] args){
    // }
}