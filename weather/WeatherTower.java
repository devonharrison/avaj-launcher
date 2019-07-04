package weather;
import weather.Coordinates;
import weather.WeatherProvider;
import java.util.Random;

public class WeatherTower{
    public String getWeather(Coordinates coordinates){
        int height = coordinates.getHeight();
        int lati = coordinates.getLatitude();
        int longi = coordinates.getLongitude();
        String [] weath = new String[4];
        weath[0] = "RAIN";
        weath[1] = "FOG";
        weath[2] = "SUN";
        weath[3] = "SNOW";
        String ret;
        int index = 0;
        if ((height >=  0 && height <= 100) && lati >= 0 && longi >= 0){
            index = (height + longi + lati) % 4;
            ret = weath[index];
        }
        else{
            ret = "Invalid coordinates";
            System.out.println(ret);
        }
        return (ret);
    }
    public void changeWeather(){

    }
}