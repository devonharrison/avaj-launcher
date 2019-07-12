import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import weather.*;
import aircrafts.*;
import avajutils.AvajFileWriter;
import avajutils.CustomException;

import java.io.FileWriter;

public class Simulation{
    public static void main(String [] args){
        WeatherTower weatherTower = new WeatherTower();
        int argc = args.length;
        if (argc != 1){
            System.out.println("Incorrect number of arguments");
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
                            System.out.println("[ERROR] Invalid number of simulations to run.\nExiting ...");
                            System.exit(0);
                        }
                    } catch(Exception e){
                        System.out.print("[ERROR] " + e + "\n");
                    }
                }
                try{
                    File file = new File("simulation.txt");
                    FileWriter fw = new FileWriter(file);
                    while ((line = buf.readLine()) != null){
                        if (line.split(" ").length == 5){
                            String type = line.split(" ")[0].toLowerCase();
                            String name = line.split(" ")[1];
                            int longi = Integer.parseInt(line.split(" ")[2]);
                            int lati = Integer.parseInt(line.split(" ")[3]);
                            int height = Integer.parseInt(line.split(" ")[4]);
                            Flyable flyable = new AircraftFactory().newAircraft(type, name, longi, lati, height);
                            flyable.registerTower(weatherTower);
                        }
                        else{
                            System.out.println("[ERROR] Incorrect file scenario structure.\n Exiting ...");
                            System.exit(0);
                        }
                    }
                    for (int i = 0; i < sim; i++){
                            weatherTower.changeWeather();
                    }
                    buf.close();
                    AvajFileWriter.OutputWriter(fw);
                    fw.close();
                } catch (Exception e){
                    System.out.println("[ERROR] " + e);
                }
            }catch(Exception e){
                System.out.println("[ERROR] " + e);
            }
        }
    }
}
