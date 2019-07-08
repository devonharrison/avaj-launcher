import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import weather.*;
import aircrafts.*;
import avajutils.AvajFileWriter;
import java.io.FileWriter;

public class Simulation{
    public static void main(String [] args){
        WeatherTower weatherTower = new WeatherTower();
            int argc = args.length;
            if (argc == 0){
                System.out.println("Please give me a scenario");
            }
            else {
                try{
                    int sim = 0;
                    BufferedReader buf = new BufferedReader(new FileReader(args[0]));
                    String line = buf.readLine();
                    if (line != null){
                        try {
                            sim = Integer.parseInt(line);
                            if (sim < 0){
                                System.out.println("Invalid number of simulations to run.");
                            }
                        } catch(Exception e){
                            System.out.println("File needs to begin with a positive integer.");
                        }
                    }
                    try{
                        File file = new File("simulation.txt");
                        FileWriter fw = new FileWriter(file);
                        while ((line = buf.readLine()) != null){
                            String type = line.split(" ")[0].toLowerCase();
                            String name = line.split(" ")[1];
                            int longi = Integer.parseInt(line.split(" ")[2]);
                            int lati = Integer.parseInt(line.split(" ")[3]);
                            int height = Integer.parseInt(line.split(" ")[4]);
                            Flyable flyable = new AircraftFactory().newAircraft(type, name, longi, lati, height);
                            flyable.registerTower(weatherTower);
                        }
                        try {
                            for (int i = 0; i < sim; i++){
                                weatherTower.changeWeather();
                                //FIX THIS
                                System.out.println(i);
                            }
                        } catch(Exception e){
                            System.out.print(e);
                        }
                        buf.close();
                        AvajFileWriter.OutputWriter(fw);
                        fw.close();
                    } catch (Exception e){
                        System.out.println("Error registering aircrafts");
                    }
                } catch(Exception e){
                    System.out.println("Error reading file");
                }
            }
    }
}
