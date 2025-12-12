package exceptions;

public class EditorNotFoundException extends RuntimeException {

    public EditorNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "EditorNotFoundException: " + super.getMessage();
    }
}
