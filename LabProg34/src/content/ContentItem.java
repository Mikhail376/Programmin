package content;

import java.util.Objects;


public abstract class ContentItem implements Readable {
    protected String title;
    protected String author;
    protected int readerInterestLevel;

    public ContentItem(String title, String author, int readerInterestLevel) {
        this.title = title;
        this.author = author;
        this.readerInterestLevel = readerInterestLevel;
    }

    public abstract String read();

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getReaderInterestLevel() {
        return readerInterestLevel;
    }

    @Override
    public String toString() {
        return "Материал: \"" + title + "\" (Автор: " + author +
                "), интерес читателя: " + readerInterestLevel;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContentItem)) return false;
        ContentItem that = (ContentItem) o;
        return readerInterestLevel == that.readerInterestLevel &&
                Objects.equals(title, that.title) &&
                Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, readerInterestLevel);
    }
}
