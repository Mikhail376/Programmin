package content;

public class Humoresque extends ContentItem {

    private static final String DEFAULT_AUTHOR = "Неизвестный";

    public Humoresque(String title, int level) {
        super(title, DEFAULT_AUTHOR, level);
    }

    @Override
    public String read() {
        return "Юмореска: \"" + title + "\" (Автор: " + author + ") — интерес: " + readerInterestLevel;
    }

    @Override
    public String toString() {
        return "Humoresque{title='" + title + "', author='" + author + "', interest=" + readerInterestLevel + "}";
    }
}
