package content;


public class Article extends ContentItem {

    public Article(String title, String author, int level) {
        super(title, author, level);
    }

    @Override
    public String read() {
        return "Рассказ/Статья: \"" + title + "\" (Автор: " + author + ") — интерес: " + readerInterestLevel;
    }
}
