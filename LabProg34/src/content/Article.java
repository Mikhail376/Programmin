package content;


public class Article extends ContentItem {

    public Article(String title, String author, int level) {
        super(title, author, level);
    }

    @Override
    public String read() {
        return "Рассказ/Статья: \"" + title + "\" (Автор: " + author + ") — интерес: " + readerInterestLevel;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Рассказ/Статья: \"" + getTitle() +
                "\" (Автор: " + author +
                ") — интерес: " + readerInterestLevel;
    }

}
