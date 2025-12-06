package content;

public class Advertisement extends ContentItem {

    private String product;

    public Advertisement(String product, int level) {
        super("Реклама: " + product, "Struts", level);
        this.product = product;
    }

    @Override
    public String read() {
        return "Реклама продукта \"" + product + "\" (Рекламодатель: " + author + ") — интерес: " + readerInterestLevel;
    }

    public String getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Advertisement{product='" + product + "', author='" + author + "', interest=" + readerInterestLevel + "}";
    }
}
