import java.io.*;
import java.util.Scanner;
import java.util.*;
public class Solution{
    // private static String st;
    ArrayList<String> list1 = new ArrayList<>();
    ArrayList<String> list2 = new ArrayList<>();
    ArrayList<String> list3 = new ArrayList<>();
    Digraph V;
    public Solution() throws FileNotFoundException {
        this.parseLogs();
        V = new Digraph(list1.size());
        this.parsemails();
    }

public void parseLogs() throws FileNotFoundException{
    File file = new File("C:\\Users\\Manjari Murala\\Desktop\\Exam\\ADS - 2 Exam - 1\\email-logs.txt");
    Scanner sc = new Scanner(file);
    while(sc.hasNextLine()){
        String[] arr = sc.nextLine().split(",");
        list2.add(arr[0]);
        int c = 0;
        for(int i = 1; i < arr.length; i++){
            V.addEdge(Integer.parseInt(arr[c],Integer.parseInt(arr[i])), i);
        }
        for(int i = 1; i < arr.length; i++){
            list3.add(arr[i]);
        }
        System.out.println(arr[0]);
    }
    sc.close();
}


public void parsemails() throws FileNotFoundException{
    File file = new File("C:\\Users\\Manjari Murala\\Desktop\\Exam\\ADS - 2 Exam - 1\\emails.txt");
    Scanner sc = new Scanner(file);
    while(sc.hasNextLine()){
        String[] arr = sc.nextLine().split(",");
        System.out.println(arr[0]);
    }
    sc.close();
}

public static void main(String[] args) throws FileNotFoundException {
    Solution obj = new Solution();
    obj.parseLogs();
    obj.parsemails();

}
}