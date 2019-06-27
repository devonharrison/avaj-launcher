package aircrafts;
import weather.WeatherTower;

interface Flyable{
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}