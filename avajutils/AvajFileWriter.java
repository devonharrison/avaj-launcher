package avajutils;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class AvajFileWriter{
    private static List<String> msg = new ArrayList<String>();
    static public void OutputWriter(FileWriter fw){
       
        try{
            for(String line: msg){
                fw.write(line);
            }

        } catch(Exception e){
            System.out.println("Error writing to file: simulation.txt");
        }
    }
    static public void addToArr(String str){
        msg.add(str + "\n");
    }
}