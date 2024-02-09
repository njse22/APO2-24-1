package exceptions;

public class PersonDoesNotExist extends RuntimeException {

    private String message;

    public PersonDoesNotExist(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
