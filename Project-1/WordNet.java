
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Iterable;

 import edu.princeton.cs.algs4.Digraph;
 import edu.princeton.cs.algs4.DirectedCycle;
 import edu.princeton.cs.algs4.LinearProbingHashST;
 import edu.princeton.cs.algs4.In;

public class WordNet{
    private final LinearProbingHashST<String, ArrayList<Integer>> Ht;
    private final  Digraph D;
    private final ArrayList<String> syns = new ArrayList<String>();
    private final SAP sap;

    public WordNet(String synsetsFile, String hypernymsFile){
        Ht = new LinearProbingHashST<String, ArrayList<Integer>>();
        int c = parseSynsets(synsetsFile);
        D = parseHypernyms(hypernymsFile,c);
        sap = new SAP(D);
    }
    
    
    private int parseSynsets(String sysnsetsFile) {
        In in = new In(sysnsetsFile);
        String line;
        int count = 0;
        while(in.hasNextLine()){
            line = in.readLine();
            String[]data = line.split(",");
            int first = Integer.parseInt(data[0]);
            syns.add(first,data[1]);
            String[] token = data[1].split(" ");
            count++;
            for(int j = 0; j < token.length; j++){
                String noun = token[j].trim();
                if(!Ht.contains(noun)) {
                    ArrayList<Integer> id = new ArrayList<Integer>();
                    id.add(first);
                    Ht.put(noun,id);
                }
                else{
                    Ht.get(noun).add(Integer.parseInt(data[0]));
                }
            } 
        }
        return count;
    }
    private Digraph parseHypernyms(String hypernymFile, int c){
        In in  = new In(hypernymFile);
        Digraph D = new Digraph(c);
        while(in.hasNextLine()) {
            String[] token = in.readLine().split(",");
            for(int i = 1; i < token.length; i++){
                D.addEdge(Integer.parseInt(token[0]), Integer.parseInt(token[i]));

            }
        }
        return D;

    }
    
    
    public Iterable<String> nouns(){
        return Ht.keys();
    }
    public boolean isNoun(String word) {
        if(word == null){
            throw new IllegalArgumentException();
        }
        return Ht.contains(word);
    }
    public int distance(String nounA, String nounB){
        if(!isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException();
        }
        return sap.length(Ht.get(nounA), Ht.get(nounB));
    }
    public String sap(String nounA, String nounB) {
        if(isNoun(nounA) && isNoun(nounB)){
            int anc = sap.ancestor(Ht.get(nounA),Ht.get(nounB));
            if(anc != -1){
                return syns.get(anc);
            }else{
                return "there is no common ancestor";
            }
         }
        else{
               throw new IllegalArgumentException();
          }
    }
        
}