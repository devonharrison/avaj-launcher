import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import weather.Coordinates;
import weather.WeatherTower;
import aircrafts.AircraftFactory;
import aircrafts.Flyable;

public class Simulation{
    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<>();
    public static void main(String [] args){
        try{
            int argc = args.length;
            if (argc == 0){
                System.out.println("Please give me a scenario");
            }
            else {
                try {
                    BufferedReader buf = new BufferedReader(new FileReader(args[0]));
                    String line = buf.readLine();
                    if (line != null){
                        weatherTower = new WeatherTower();
                        int sim = Integer.parseInt(line.split("\n")[0]);
                        if (sim < 0){
                            System.out.println("Invalid number of simulations to run " + sim);
                            System.exit(1);
                        }
                        while((line = buf.readLine()) != null){
                            Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1], Integer.parseInt(line.split(" ")[2]),
                                Integer.parseInt(line.split(" ")[3]),
                                Integer.parseInt(line.split(" ")[4]));
                            flyables.add(flyable);
                        }
                        for(Flyable flyable : flyables){
                            flyable.registerTower(weatherTower);
                        }
                        for (int i = 1; i <= sim; i++){
                            weatherTower.changeWeather();
                        }
                    }
                    WeatherTower a = new WeatherTower();
                    Coordinates coordinates = new Coordinates();
                    System.out.println(a.getWeather(coordinates));
                    buf.close();
                    // String fileName = args[0];
                    // InputStream is = new FileInputStream(fileName);
                    // BufferedReader buf = new BufferedReader(new InputStreamReader(is));
                    // String line = buf.readLine();
                    // StringBuilder sb = new StringBuilder();
                    // while(line != null){
                    //     sb.append(line).append("\n");
                    //     line = buf.readLine();
                    // } 
                    // String fileAsString = sb.toString();
                    // String [] fileInArr = fileAsString.split("\n");
                    // int len = fileInArr.length;
                    // int i = 0;
                    // while (i < len){
                    //     String [] tmp = fileInArr[i].split(" ");
                    // }
                    // is.close();
                } catch (Exception e){
                    System.out.println("Error reading file");
                } 
            }
        } catch(Exception e){
            System.out.println("Error: ");
        }
    }
}
