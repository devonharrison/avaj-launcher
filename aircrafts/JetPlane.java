package aircrafts;
import weather.WeatherTower;
import weather.Coordinates;
import aircrafts.Flyable;
import avajutils.AvajFileWriter;
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
                AvajFileWriter.addToArr("Jetplane#" + this.name + "(" + this.id + "): " + "it's getting quite toasty up here");
                break ;
            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude(),
                coordinates.getLatitude() + 5, coordinates.getHeight());
                AvajFileWriter.addToArr("Jetplane#" + this.name + "(" + this.id + "): " + "it's poring, I'm sure some old men are snoring");
                break ;
            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude(),
                coordinates.getLatitude() + 1, coordinates.getHeight());
                AvajFileWriter.addToArr("Jetplane#" + this.name + "(" + this.id + "): " + "the fog doesn't affect you if you're blind");
                break ;
            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude(),
                coordinates.getLatitude(), coordinates.getHeight() - 7);
                AvajFileWriter.addToArr("Jetplane#" + this.name + "(" + this.id + "): " + "the snow means go low");
                break ;
        }
        if (this.coordinates.getHeight() <= 0){
            unregisterTower(weatherTower);
        }
    }
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        AvajFileWriter.addToArr("Tower says: JetPlane#" + this.name + "(" + this.id + ") " + "registered to weather tower.");
    }
    public void unregisterTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.unregister(this);
        AvajFileWriter.addToArr("Tower says: JetPlane#" + this.name + "(" + this.id + ") " + "has landed.");
    }
}