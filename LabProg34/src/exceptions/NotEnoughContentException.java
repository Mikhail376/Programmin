package exceptions;

public class NotEnoughContentException extends Exception {
    public static final int MIN_REQUIRED = 3;

    @Override
    public String getMessage() {
        return "Недостаточно материалов для публикации: требуется минимум " + MIN_REQUIRED;
    }
}
