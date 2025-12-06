package exceptions;

public class NotEnoughContentException extends Exception {
    private final int minRequired;

    public NotEnoughContentException(int minRequired) {
        super("Not enough content, need at least " + minRequired);
        this.minRequired = minRequired;
    }

    public int getMinRequired() {
        return minRequired;
    }

    @Override
    public String getMessage() {
        return "NotEnoughContentException: требуется минимум " + minRequired + " элементов контента.";
    }
}
