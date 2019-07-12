package weather;

import java.util.Random;
import weather.Coordinates;

public class WeatherProvider{
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    WeatherProvider(){

    }
    public static WeatherProvider getProvider(){
        return(weatherProvider); 
    }
    public String getCurrentWeather(Coordinates coordinates){
        int longi = coordinates.getLongitude();
        int lati = coordinates.getLatitude();
        int height = coordinates.getHeight();
        Random rand = new Random();
        int index = ((longi + lati + height) + rand.nextInt(50)) % 4;
        return (weather[index]);
    } 
}