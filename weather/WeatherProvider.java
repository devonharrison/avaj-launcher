package weather;
import weather.Coordinates;
import weather.Tower;

public class WeatherProvider{
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    WeatherProvider(){

    }
    public WeatherProvider getProvider(){
        return(weatherProvider); 
    }
    public String getCurrentWeather(Coordinates coordinates){
        int longi = coordinates.getLongitude();
        int lati = coordinates.getLatitude();
        int height = coordinates.getHeight();
        int index = (longi + lati + height) % 4;
        return (weather[index]);
    } 
}