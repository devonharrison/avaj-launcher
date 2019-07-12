package aircrafts;
import weather.WeatherTower;
import weather.Coordinates;
import aircrafts.Aircraft;
import aircrafts.Flyable;
import avajutils.AvajFileWriter;

public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;
    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    public void updateConditions(){
        String weather = weatherTower.getWeather(this.coordinates);
        switch(weather){
            case "SUN":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 2,
                coordinates.getLatitude(), coordinates.getHeight() + 2);
                AvajFileWriter.addToArr("Baloon#" + this.name + "(" + this.id + "): " + "I would like AC, but there's no point");
                break ;
            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude(),
                coordinates.getLatitude(), coordinates.getHeight() - 5);
                AvajFileWriter.addToArr("Baloon#" + this.name + "(" + this.id + "): " + "Wish we had some wipers, but again, no point");
                break ;
            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude(),
                coordinates.getLatitude(), coordinates.getHeight() - 3);
                AvajFileWriter.addToArr("Baloon#" + this.name + "(" + this.id + "): " + "Some condensation for the soul");
                break ;
            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude(),
                coordinates.getLatitude(), coordinates.getHeight() - 15);
                AvajFileWriter.addToArr("Baloon#" + this.name + "(" + this.id + "): " + "It's cold, freezing in fact");
                break ;
        }
        if (this.coordinates.getHeight() == 0){
            unregisterTower(weatherTower);
            AvajFileWriter.addToArr("Tower says: Baloon#" + this.name + "(" + this.id + ") " + "Longitude: " + coordinates.getLongitude()
            + "\nLatitude: " + coordinates.getLatitude() + "\nHeight: " + coordinates.getHeight());
        }
    }
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        AvajFileWriter.addToArr("Tower says: Baloon#" + this.name + "(" + this.id + ") " + "registered to weather tower.");
    }
    public void unregisterTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.unregister(this);
        AvajFileWriter.addToArr("Tower says: Baloon#" + this.name + "(" + this.id + ") " + "has landed.");
    }
}