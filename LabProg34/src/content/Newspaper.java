package content;

import exceptions.NotEnoughContentException;
import util.PaperType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Newspaper implements Publishable {

    private String name;
    private PaperType type;
    private final List<ContentItem> content;
    private boolean isPublished;

    private static final int MIN_REQUIRED = 2;
    public Newspaper(String name, PaperType type) {
        this.name = name;
        this.type = type;
        this.content = new ArrayList<>();
        this.isPublished = false;
    }

    public void addContent(ContentItem item) {
        if (item == null) throw new IllegalArgumentException("ContentItem cannot be null");
        content.add(item);
    }

    @Override
    public void publish() throws NotEnoughContentException {
        if (content.size() < MIN_REQUIRED) {
            throw new NotEnoughContentException(MIN_REQUIRED);
        }

        isPublished = true;

        System.out.println("ПУБЛИКАЦИЯ: " + name + " (" + type + ")");

        for (ContentItem с : content) {
            System.out.println(с.read());
        }

        System.out.println("КОНЕЦ ВЫПУСКА");

        evaluateSuccess();
    }


    public void addStubContent() {
        Humoresque stub = new Humoresque("Заглушка: материал готовится", 2);
        content.add(stub);
        Advertisement adStub = new Advertisement("Заглушка-реклама", 1);
        content.add(adStub);
        System.out.println("Добавлены заглушки (humoresque + advertisement).");
    }

    public List<ContentItem> getContent() {
        return content;
    }

    public boolean isPublished() {
        return isPublished;
    }
    private void evaluateSuccess() {
        int humoresques = 0;
        int ads = 0;
        int articles = 0;

        for (ContentItem item : content) {
            if (item instanceof Humoresque) humoresques++;
            else if (item instanceof Advertisement) ads++;
            else if (item instanceof Article) articles++;
        }

        System.out.println("ОЦЕНКА УСПЕХА ВЫПУСКА");

        if (humoresques > ads && humoresques > articles) {
            System.out.println("Успех: ВЫСОКИЙ ИНТЕРЕС ЧИТАТЕЛЕЙ");
            System.out.println("Причина: много юморесок — публика в восторге!");
        }
        else if (ads > humoresques && ads > articles) {
            System.out.println("Успех: НИЗКИЙ ИНТЕРЕС, НО ВЫСОКИЕ ДОХОДЫ");
            System.out.println("Причина: слишком много рекламы, но издатель доволен.");
        }
        else if (articles > humoresques && articles > ads) {
            System.out.println("Успех: СРЕДНИЙ — ЧИТАТЕЛИ НЕДОВОЛЬНЫ");
            System.out.println("Причина: много художественных рассказов — читали ради юморесок.");
        }
        else {
            System.out.println("Успех: СМЕШАННЫЙ");
            System.out.println("Причина: баланс материалов нестандартный.");
        }

        System.out.println("КОНЕЦ ОЦЕНКИ");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Newspaper)) return false;
        Newspaper that = (Newspaper) o;
        return isPublished == that.isPublished &&
                Objects.equals(name, that.name) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, isPublished);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== ВЫПУСК ГАЗЕТЫ: ").append(name)
                .append(" (").append(type).append(") ===\n");

        for (ContentItem item : content) {
            sb.append(item.toString()).append("\n");
        }

        sb.append("=== КОНЕЦ ВЫПУСКА ===\n");
        return sb.toString();
    }

}
