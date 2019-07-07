import java.io.BufferedReader;
import java.io.FileReader;
import weather.*;
import aircrafts.*;

public class Simulation{
    static WeatherTower weatherTower = new WeatherTower();
    public static void main(String [] args){
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
                        while ((line = buf.readLine()) != null){
                            String type = line.split(" ")[0].toLowerCase();
                            String name = line.split(" ")[1];
                            int longi = Integer.parseInt(line.split(" ")[2]);
                            int lati = Integer.parseInt(line.split(" ")[3]);
                            int height = Integer.parseInt(line.split(" ")[4]);
                            Flyable flyable = new AircraftFactory().newAircraft(type, name, longi, lati, height);
                            flyable.registerTower(weatherTower);
                        }
                        try{
                            for (int i = 0; i < sim; i++){
                                weatherTower.changeWeather();
                            }
                        }catch(Exception e){
                            System.out.println("Error here fam");
                        }

                    } catch (Exception e){
                        System.out.println("Error registering aircrafts");
                    }
                    buf.close();
                } catch(Exception e){
                    System.out.println("Error reading file");
                }
            }
    }
}
