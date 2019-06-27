package aircrafts;
import weather.Coordinates;

public class Aircraft{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter;
    protected Aircraft(String name, Coordinates coordinates){
        System.out.println("In aricraft class");
    }
    public Aircraft(){
        System.out.println("Constructor called");
    }
    private long nextId(){
        return (this.idCounter++);
    }
    public void test() {
        System.out.println("In aricraft class");
    }
}