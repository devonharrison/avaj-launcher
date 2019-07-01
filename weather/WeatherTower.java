package weather;
import weather.Coordinates;
import weather.WeatherProvider;

public class WeatherTower{
    public String getWeather(Coordinates coordinates){
        int height = coordinates.getHeight();
        int lati = coordinates.getLatitude();
        int longi = coordinates.getLongitude();
        String conditions = null;
        if ((height >=  0 && height <= 100) && lati >= 0 && longi >= 0){
            if (height >= 0 && height <= 25){
                if ((longi >= 0 && longi < 25) || (lati >= 0 && lati < 25)){
                    if (longi % 2 == 0){
                        conditions = "RAIN";
                    }
                    else {
                        conditions = "FOG";
                    }
                    if (lati % 2 == 0){
                        conditions = "SUN";
                    }
                    else {
                        conditions = "SNOW";
                    }
                }
            }
            if (height > 25 && height <= 50){
                if ((longi >= 25 && longi < 50) || (lati >= 25 && lati < 50)){
                    if (longi % 2 == 0){
                        conditions = "RAIN";
                    }
                    else {
                        conditions = "FOG";
                    }
                    if (lati % 2 == 0){
                        conditions = "SUN";
                    }
                    else {
                        conditions = "SNOW";
                    }
                }
            }
            if (height > 50 && height <= 75){
                if ((longi >= 50 && longi < 75) || (lati >= 50 && lati < 75)){
                    if (longi % 2 == 0){
                        conditions = "RAIN";
                    }
                    else {
                        conditions = "FOG";
                    }
                    if (lati % 2 == 0){
                        conditions = "SUN";
                    }
                    else {
                        conditions = "SNOW";
                    }
                }
            }
            if (height > 75 && height <= 100){
                if (longi >= 75 || lati >= 75){
                    if (longi % 2 == 0){
                        conditions = "RAIN";
                    }
                    else {
                        conditions = "FOG";
                    }
                    if (lati % 2 == 0){
                        conditions = "SUN";
                    }
                    else {
                        conditions = "SNOW";
                    }
                }
            }
        }
        else{
            System.out.println("Invalid coordinates");
        }
        return(conditions);
    }
    public void changeWeather(){

    }
}