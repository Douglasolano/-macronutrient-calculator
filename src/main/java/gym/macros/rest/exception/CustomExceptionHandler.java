package gym.macros.rest.exception;

public class CustomExceptionHandler extends RuntimeException{

    public CustomExceptionHandler(String message) {
        super(message);
    }
}
