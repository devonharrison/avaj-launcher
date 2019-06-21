package launcher;
import launcher.Coordinates;

class WeatherProvider{
    private WeatherProvider weatherProvider;
    private String[] weather;
    private WeatherProvider(){
        this.weather[0] = "RAIN";
        this.weather[1] = "FOG";
        this.weather[2] = "SUN";
        this.weather[3] = "SNOW";
    }
    public WeatherProvider getProvider(){
        return(this); 
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