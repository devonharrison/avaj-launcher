package weather;
import weather.Coordinates;

class WeatherProvider{
    private WeatherProvider weatherProvider = new WeatherProvider();
    private String[] weather;
    private WeatherProvider(){
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

            }
            if (height > 25 && height <= 50){

            }
            if (height > 50 && height <= 75){

            }
            if (height > 75 && height <= 100){

            }
        }
        else{
            System.out.println("Invalid coordinates");
        }
        return(conditions);
    } 
}