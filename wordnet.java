import java.io.*;
import java.util.Scanner;
public class wordnet{
    public void parseHypernyms() throws FileNotFoundException {
        File file = new File("C:\\Users\\Manjari Murala\\Desktop\\ADS-2\\Day-1\\hypernyms.txt"); 
        Scanner s = new Scanner(file);
        while (s.hasNextLine()) { 
            String[] arr = s.nextLine().split(",");
            System.out.println(arr[0]);
        } 
    }

    public void parseSynsets() throws FileNotFoundException {
        File file = new File("C:\\Users\\Manjari Murala\\Desktop\\ADS-2\\Day-1\\synsets.txt"); 
        Scanner s = new Scanner(file);
        while (s.hasNextLine()) { 
            String[] arr = s.nextLine().split(",");
            System.out.println(arr[0]);
        } 
    }
    public static void main(String[] args) throws FileNotFoundException {
        wordnet w = new wordnet();
        w.parseHypernyms();
        w.parseSynsets();
    }
}