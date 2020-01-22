import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Outcast {
    private final WordNet wordnet;
    public Outcast(WordNet wordnet){
        this.wordnet = wordnet;
    }
    public String outcast(String[] nouns){
        int len = nouns.length;
        int [] temp = new int[len];
        for(int i = 0; i < len-1; i++){
            for(int j = i+1; j < len; j++){
                int Temp = wordnet.distance(nouns[i],nouns[j]);
                temp[i] += Temp;
                temp[j] += Temp;
            }
        }
        int MaxDistance = 0;
        int first = 0;
        for(int i = 0; i < len; i++){
            if(temp[i] > MaxDistance) {
                MaxDistance = temp[i];
                first = i;
            }
        }
        return nouns[first];

    }
    // public static void main(String[] args){
        
    // }
}