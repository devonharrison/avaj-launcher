package aircrafts;
import weather.WeatherTower;
import weather.Coordinates;
import aircrafts.Aircraft;
import aircrafts.Flyable;

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
                break ;
            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 5,
                coordinates.getLatitude(), coordinates.getHeight());
                break ;
            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 1,
                coordinates.getLatitude(), coordinates.getHeight());
                break ;
            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude(),
                coordinates.getLatitude(), coordinates.getHeight() - 12);
                break ;
        }
    }
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.print("Tower says: Helicopter#" + this.name + "(" + this.id + ") " + "registered to weather tower.");
    }
}