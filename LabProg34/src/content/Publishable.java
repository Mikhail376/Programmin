package content;
import exceptions.NotEnoughContentException;

public interface Publishable {
    void publish() throws NotEnoughContentException;
}
