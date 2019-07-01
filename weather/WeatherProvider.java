package weather;
import weather.Coordinates;

public class WeatherProvider{
    private WeatherProvider weatherProvider = new WeatherProvider();
    private String[] weather;
    WeatherProvider(){
        weatherProvider.weather[0] = "RAIN";
        weatherProvider.weather[1] = "FOG";
        weatherProvider.weather[2] = "SUN";
        weatherProvider.weather[3] = "SNOW";
    }
    public WeatherProvider getProvider(){
        return(weatherProvider); 
    }
    public String getCurrentWeather(Coordinates coodinates){
        int height = coodinates.getHeight();
        int lati = coodinates.getLatitude();
        int longi = coodinates.getLongitude();
        String conditions = null;
        if ((height >=  0 && height <= 100) && lati >= 0 && longi >= 0){
            if (height >= 0 && height <= 25){
                if ((longi >= 0 && longi < 25) || (lati >= 0 && lati < 25)){
                    if (longi % 2 == 0){
                        conditions = weatherProvider.weather[0];
                    }
                    else {
                        conditions = weatherProvider.weather[1];
                    }
                    if (lati % 2 == 0){
                        conditions = weatherProvider.weather[2];
                    }
                    else {
                        conditions = weatherProvider.weather[3];
                    }
                }
            }
            if (height > 25 && height <= 50){
                if ((longi >= 25 && longi < 50) || (lati >= 25 && lati < 50)){
                    if (longi % 2 == 0){
                        conditions = weatherProvider.weather[0];
                    }
                    else {
                        conditions = weatherProvider.weather[1];
                    }
                    if (lati % 2 == 0){
                        conditions = weatherProvider.weather[2];
                    }
                    else {
                        conditions = weatherProvider.weather[4];
                    }
                }
            }
            if (height > 50 && height <= 75){
                if ((longi >= 50 && longi < 75) || (lati >= 50 && lati < 75)){
                    if (longi % 2 == 0){
                        conditions = weatherProvider.weather[0];
                    }
                    else {
                        conditions = weatherProvider.weather[1];
                    }
                    if (lati % 2 == 0){
                        conditions = weatherProvider.weather[2];
                    }
                    else {
                        conditions = weatherProvider.weather[3];
                    }
                }
            }
            if (height > 75 && height <= 100){
                if (longi >= 75 || lati >= 75){
                    if (longi % 2 == 0){
                        conditions = weatherProvider.weather[0];
                    }
                    else {
                        conditions = weatherProvider.weather[1];
                    }
                    if (lati % 2 == 0){
                        conditions = weatherProvider.weather[2];
                    }
                    else {
                        conditions = weatherProvider.weather[3];
                    }
                }
            }
        }
        else{
            System.out.println("Invalid coordinates");
        }
        return(conditions);
    } 
}