package aircrafts;
import weather.Coordinates;

public class Aircraft{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter = 0;
    protected Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        nextId();
    }
    public Aircraft(){
        System.out.println("Constructor called");
    }
    private long nextId(){
        return (this.idCounter++);
    }
}