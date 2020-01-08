import java.io.*;
import java.util.*;
public class WordNet1{
    ArrayList<String> list1 = new ArrayList<>();
    ArrayList<String> list2 = new ArrayList<>();
    ArrayList<String> list3 = new ArrayList<>();
    DiGraph V;
    public WordNet1() throws Exception{
        this.parseSynset();
        V = new DiGraph(list1.size());
        this.parseHypernym();
        System.out.println(V.size());
        int c = 0;
        for (int i = 0; i < V.size(); i++) {
            c = c + V.adj[i].size();
        }
        System.out.println(c);
    }

    private void parseHypernym() throws FileNotFoundException {
        File file = new File("C:\\Users\\Manjari Murala\\Desktop\\ADS-2\\Day-1\\hypernyms.txt");
        Scanner s = new Scanner(file);
        while (s.hasNextLine()){
            String[] st1 = s.nextLine().split(",");
            list2.add(st1[0]);
            int c = 0;
            for(int i = 1; i < st1.length; i++){
                V.addEdge(Integer.parseInt(st1[c]),Integer.parseInt(st1[i]));
            }
            for(int i = 1; i < st1.length; i++){
                list3.add(st1[i]);
            }
        }
    s.close();
    }

    private void parseSynset() throws Exception {
        File file = new File("C:\\Users\\Manjari Murala\\Desktop\\ADS-2\\Day-1\\synsets.txt");
        Scanner s = new Scanner(file);
        while (s.hasNextLine()){
            String[] st = s.nextLine().split(",");
            list1.add(st[0]);
        }
    s.close();
    }
    public static void main(String[]args) throws Exception {
        WordNet1 w = new WordNet1();
        w.parseHypernym();
        w.parseSynset();
    }
}