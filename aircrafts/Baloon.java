package aircrafts;
import weather.WeatherTower;
import weather.Coordinates;
import aircrafts.Aircraft;

class Baloon extends Aircraft{
    private WeatherTower weatherTower;
    Baloon(String name, Coordinates coordinates){
        Aircraft Baloon = new Aircraft(name, coordinates);
    }
    public void updateConditions(){
        
    }
    public void registerTower(WeatherTower weatherTower){
        
    }
}