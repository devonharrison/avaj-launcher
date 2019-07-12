package weather;
import weather.Coordinates;
import weather.WeatherProvider;
import weather.Tower;

public class WeatherTower extends Tower{
    public String getWeather(Coordinates coordinates){
        WeatherProvider weather = new WeatherProvider();
        return (weather.getCurrentWeather(coordinates));
    }
    public void changeWeather(){
        this.conditionsChanged();
    }
}