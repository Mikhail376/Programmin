import content.*;
import exceptions.NotEnoughContentException;
import persons.Grizel;
import persons.MrKrabs;
import util.PaperType;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(" Запуск сценария по диаграмме и сценарию");

        Grizel grizel = new Grizel();
        MrKrabs krabs = new MrKrabs();

        System.out.println("Редактор: " + grizel);
        System.out.println("Внешность: " + grizel.getAppearance());
        System.out.println("Манускрипты: " + grizel.getManuscripts());

        try {
            krabs.enterOffice(grizel);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("MrKrabs: Попробует вернуться позже.");
            grizel.setState("HAPPY");
            System.out.println("Grizel сменил состояние на HAPPY и принимает посетителя.");
        }

        List<ContentItem> submissions = new ArrayList<>();
        submissions.add(new Article("Новости порта", "Ivanov", 5));
        submissions.add(new Humoresque("Как Спрутс продавал сахар", 8));
        submissions.add(new Advertisement("Спрутсовский сахар", 3));
        if (Math.random() > 0.5) {
            submissions.add(new Article("Ночной рассказ", "Petrov", 4));
        }

        Newspaper newspaper = new Newspaper("Spruts Gazette", PaperType.CHEAP_PULP);

        for (ContentItem item : submissions) {
            try {
                newspaper.addContent(item);
                System.out.println("Добавлен материал: " + item.getTitle());
            } catch (Exception e) {
                System.out.println("Ошибка при добавлении: " + e.getMessage());
            }
        }

        try {
            newspaper.publish();
        } catch (NotEnoughContentException e) {
            System.out.println(e.getMessage());
            System.out.println("Добавляем заглушку и пробуем снова.");
            newspaper.addStubContent();
            try {
                newspaper.publish();
            } catch (NotEnoughContentException ex) {
                System.out.println("Не удалось опубликовать даже после заглушки: " + ex.getMessage());
            }
        }
    }
}
