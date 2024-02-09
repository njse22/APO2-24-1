package exceptions;

public class DuplicatePersonException extends Exception {

    private String message;

    public DuplicatePersonException(String message){
        super(message);
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
