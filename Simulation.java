import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import aircrafts.Aircraft;

public class Simulation{
    public static void main(String [] args){
        try{
            int argc = args.length;
            if (argc == 0){
                System.out.println("Please give me a scenario");
            }
            else {
                try {
                    String fileName = args[0];
                    InputStream is = new FileInputStream(fileName);
                    BufferedReader buf = new BufferedReader(new InputStreamReader(is));
                    String line = buf.readLine();
                    StringBuilder sb = new StringBuilder();
                    while(line != null){
                        sb.append(line).append("\n");
                        line = buf.readLine();
                    } 
                    String fileAsString = sb.toString();
                    System.out.println(fileAsString);
                    is.close();
                    Aircraft a = new Aircraft();
                    a.test();
                } catch (Exception e){
                    System.out.println("Error reading file");
                } 
            }
        } catch(Exception e){
            System.out.println("Error: ");
        }
    }
}
