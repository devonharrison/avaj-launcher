package aircrafts;
import weather.WeatherTower;
import weather.Coordinates;
import aircrafts.Aircraft;

class JetPlane extends Aircraft{
    private WeatherTower weatherTower;
    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    public void updateConditions(){
        
    }
    public void registerTower(WeatherTower weatherTower){
        
    }
}