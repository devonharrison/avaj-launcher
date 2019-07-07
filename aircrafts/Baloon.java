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
                System.out.println("Baloon#" + this.name + "(" + this.id + "): " + "I would like AC, but there's no point");
                break ;
            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude(),
                coordinates.getLatitude(), coordinates.getHeight() - 5);
                System.out.println("Baloon#" + this.name + "(" + this.id + "): " + "Wish we had some wipers, but again, no point");
                break ;
            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude(),
                coordinates.getLatitude(), coordinates.getHeight() - 3);
                System.out.println("Baloon#" + this.name + "(" + this.id + "): " + "Some condensation for the soul");
                break ;
            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude(),
                coordinates.getLatitude(), coordinates.getHeight() - 15);
                System.out.println("Baloon#" + this.name + "(" + this.id + "): " + "It's cold, freezing in fact");
                break ;
        }
    }
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ") " + "registered to weather tower.");
    }
}