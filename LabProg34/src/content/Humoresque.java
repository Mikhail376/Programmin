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
        return "Юмореска: \"" + getTitle() +
                "\" (Автор: " + author +
                ") — интерес: " + readerInterestLevel +
                " — гарантированный смех!";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Humoresque)) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
