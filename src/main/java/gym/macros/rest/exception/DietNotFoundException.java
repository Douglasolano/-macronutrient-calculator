package gym.macros.rest.exception;

public class DietNotFoundException extends RuntimeException {

    public DietNotFoundException() {
        super("Diet not found.");
    }
}