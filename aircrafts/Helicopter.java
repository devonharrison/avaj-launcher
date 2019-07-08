package aircrafts;
import weather.WeatherTower;
import weather.Coordinates;
import aircrafts.Aircraft;
import aircrafts.Flyable;
import avajutils.AvajFileWriter;

class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;
    public Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    public void updateConditions(){
        String weather = weatherTower.getWeather(this.coordinates);
        switch(weather){
            case "SUN":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 10,
                coordinates.getLatitude(), coordinates.getHeight() + 2);
                AvajFileWriter.addToArr("Helicopter#" + this.name + "(" + this.id + "): " + "blades of fire");
                break ;
            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 5,
                coordinates.getLatitude(), coordinates.getHeight());
                AvajFileWriter.addToArr("Helicopter#" + this.name + "(" + this.id + "): " + "spinning water");
                break ;
            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 1,
                coordinates.getLatitude(), coordinates.getHeight());
                AvajFileWriter.addToArr("Helicopter#" + this.name + "(" + this.id + "): " + "it looks like...nevermind, I can't see");
                break ;
            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude(),
                coordinates.getLatitude(), coordinates.getHeight() - 12);
                AvajFileWriter.addToArr("Helicopter#" + this.name + "(" + this.id + "): " + "there's a snowman on board");
                break ;
        }
        if (this.coordinates.getHeight() == 0){
            unregisterTower(weatherTower);
        }
    }
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        AvajFileWriter.addToArr("Tower says: Helicopter#" + this.name + "(" + this.id + ") " + "registered to weather tower.");
    }

    public void unregisterTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.unregister(this);
        AvajFileWriter.addToArr("Tower says: Helicopter#" + this.name + "(" + this.id + ") " + "has landed.");
    }
}