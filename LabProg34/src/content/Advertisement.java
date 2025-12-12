package content;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "Реклама продукта \"" + product +
                "\" (Рекламодатель: " + author +
                ") — интерес: " + readerInterestLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Advertisement)) return false;
        Advertisement that = (Advertisement) o;
        return super.equals(o) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), product);
    }
}
