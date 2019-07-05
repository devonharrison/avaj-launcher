package aircrafts;
import weather.WeatherTower;
import weather.Coordinates;
import aircrafts.Aircraft;

class Helicopter extends Aircraft{
    private WeatherTower weatherTower;
    public Helicopter(String name, Coordinates coordinates){
        Aircraft helicopter = new Aircraft(name, coordinates);
    }
    public void updateConditions(){
        
    }
    public void registerTower(WeatherTower weatherTower){
        
    }
}