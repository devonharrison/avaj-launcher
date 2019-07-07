package aircrafts;
import aircrafts.Flyable;
import weather.Coordinates;
import weather.WeatherTower;
import aircrafts.Baloon;
import avajexception.CustomException;

public class AircraftFactory{
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws CustomException{
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if (type == "Baloon"){
            return (new Baloon(name, coordinates));
        }
        else if (type == "JetPlane"){
            return (new JetPlane(name, coordinates));
        }
        else if (type == "Helicopter"){
            return (new Helicopter(name, coordinates));
        }
        else {
            throw new CustomException("[ERROR] Invalid aircraft type");
        }
    }
}