package weather;
import java.util.ArrayList;
import aircrafts.Flyable;

class Tower{
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();
    public void register(Flyable flyable){
        if (observers.contains(flyable)){
            System.out.println("Aircraft already registered");
        }
        else{
            observers.add(flyable);
        }
    }
    public void unregister(Flyable flyable){
        if (!observers.contains(flyable)){
            System.out.println("Aircraft is not registered");
        }
        else{
            observers.remove(flyable);
        }
    }
    protected void conditionsChanged(){
        for(int i = 0; i < observers.size(); i++){
            observers.get(i).updateConditions();
        } 
    }
}