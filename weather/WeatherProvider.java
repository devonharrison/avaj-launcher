package weather;
import weather.Coordinates;
import weather.Tower;

public class WeatherProvider{
    private WeatherProvider weatherProvider = new WeatherProvider();
    private String[] weather;
    WeatherProvider(){
        weatherProvider.weather[0] = "RAIN";
        weatherProvider.weather[1] = "FOG";
        weatherProvider.weather[2] = "SUN";
        weatherProvider.weather[3] = "SNOW";
    }
    public WeatherProvider getProvider(){
        return(weatherProvider); 
    }
    public String getCurrentWeather(Coordinates coordinates){
        WeatherTower tower = new WeatherTower();
        String currentWeather = tower.getWeather(coordinates);
        return (currentWeather);
    } 
}