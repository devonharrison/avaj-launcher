package aircrafts;
import weather.WeatherTower;
import weather.Coordinates;
import aircrafts.Aircraft;
import aircrafts.Flyable;

class Baloon extends Aircraft implements Flyable{
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
                break ;
            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude(),
                coordinates.getLatitude(), coordinates.getHeight() - 5);
                break ;
            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude(),
                coordinates.getLatitude(), coordinates.getHeight() - 3);
                break ;
            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude(),
                coordinates.getLatitude(), coordinates.getHeight() - 15);
                break ;
        }
    }
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.print("Tower says: Baloon#" + this.name + "(" + this.id + ") " + "registered to weather tower.");
    }
}