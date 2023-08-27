package gym.macros.rest.exception;

public class DietNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DietNotFoundException() {
        super("Diet not found.");
    }
}