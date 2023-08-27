package gym.macros.rest.exception;

public class BussinesRuleException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BussinesRuleException(String message) {
        super(message);
    }
}