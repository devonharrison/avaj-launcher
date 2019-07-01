package aircrafts;
import aircrafts.Flyable;
import weather.WeatherTower;

public class AircraftFactory{
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
        Flyable fly = new Flyable(){
            public void updateConditions() {
                
            }
            public void registerTower(WeatherTower weatherTower) {
                
            }
        };
        return (fly);
    }
}