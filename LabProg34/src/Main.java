import content.*;
import exceptions.NotEnoughContentException;
import persons.Grizel;
import persons.MrKrabs;
import util.PaperType;

import java.util.ArrayList;
import java.util.Collections;
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
        submissions.add(new Humoresque("Как Спрутс продавал сахар", 7000));
        submissions.add(new Humoresque("Приключения васи Попова", 7000));
        submissions.add(new Humoresque("Как Вася рыбу ловил", 7000));
        submissions.add(new Advertisement("Спрутсовский сахар", 6));
        submissions.add(new Article("Ночной рассказ", "Petrov", 4));

        List<ContentItem> randomized = new ArrayList<>(submissions);
        Collections.shuffle(randomized);
        int count = 2 + (int)(Math.random() * (randomized.size() - 1));
        List<ContentItem> selected = randomized.subList(0, count);
        selected.forEach(item -> System.out.println(" * " + item.getTitle()));


        Newspaper newspaper = new Newspaper("Spruts Gazette", PaperType.CHEAP_PULP);

        for (ContentItem item : selected) {
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
