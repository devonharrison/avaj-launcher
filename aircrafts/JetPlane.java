package aircrafts;
import weather.WeatherTower;
import weather.Coordinates;
import aircrafts.Flyable;

import aircrafts.Aircraft;

class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;
    public JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    public void updateConditions(){
        String weather = weatherTower.getWeather(this.coordinates);
        switch(weather){
            case "SUN":
                this.coordinates = new Coordinates(coordinates.getLongitude(),
                coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
                break ;
            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude(),
                coordinates.getLatitude() + 5, coordinates.getHeight());
                break ;
            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude(),
                coordinates.getLatitude() + 1, coordinates.getHeight());
                break ;
            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude(),
                coordinates.getLatitude(), coordinates.getHeight() - 7);
                break ;
        }
    }
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.print("Tower says: JetPlane#" + this.name + "(" + this.id + ") " + "registered to weather tower.");
    }
}