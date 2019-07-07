package aircrafts;
import aircrafts.Flyable;
import weather.Coordinates;
import weather.WeatherTower;
import aircrafts.Baloon;
import avajexception.CustomException;

public class AircraftFactory{
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws CustomException{
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if (type.equals("baloon")){
            return (new Baloon(name, coordinates));
        }
        else if (type.equals("jetplane")){
            return (new JetPlane(name, coordinates));
        }
        else if (type.equals("helicopter")){
            return (new Helicopter(name, coordinates));
        }
        else {
            System.out.print(type + " " + name + " " + longitude + " " + latitude + " " + height + "\n");
            throw new CustomException("[ERROR] Invalid aircraft type");
        }
    }
}