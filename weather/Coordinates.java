package weather;

 public class Coordinates{
    private int longitude;
    private int latitude;
    private int height;
    public Coordinates(int longitude, int latitude, int height){
        if (longitude < 0 || latitude < 0 || height < 0){
            
        }
        else {
            this.longitude = longitude;
            this.latitude = latitude;
            this.height = height; 
        }
    }
    public int getLongitude(){
        return(this.longitude);
    }
    public int getLatitude(){
        return(this.latitude);
    }
    public int getHeight(){
        return(this.height);
    }
}