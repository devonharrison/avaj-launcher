package avajexception;

public class CustomException extends Exception{
    private static final long serialVersionUID = 1L;
    public CustomException(String msg){
        System.out.println(msg);
    }
}