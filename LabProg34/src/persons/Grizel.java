package persons;

import util.Appearance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Grizel extends Person {

    private Appearance appearance;
    private List<String> manuscripts;

    public Grizel() {
        super("Grizel", randomState());
        this.appearance = new Appearance("длинная морда, серый пиджак, белые зубы", "серый пиджак");
        this.manuscripts = new ArrayList<>();
        manuscripts.add("Рассказ: Ночная лавка");
        manuscripts.add("Юмор: Как продавали сахар");
        manuscripts.add("Реклама: Сахар Спрутса");
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public List<String> getManuscripts() {
        return manuscripts;
    }

    public void greetVisitor() {
        String greeting = switch (state) {
            case "HAPPY" -> "Ах, рад вас видеть, проходите, у нас как раз интересное!";
            case "ANGRY" -> "Чего вам? Быстрее говорите, я занят.";
            case "TIRED" -> "Эх... да-да, проходите молча.";
            case "SAD" -> "Здравствуйте... не слишком рад, но проходите.";
            default -> "Здравствуйте.";
        };
        System.out.println("Grizel: " + greeting);
    }

    @Override
    protected String styleSpeech(String text) {
        return switch (state) {
            case "HAPPY" -> "Ох, славно: " + text;
            case "ANGRY" -> "Грубо: " + text;
            case "TIRED" -> "С усталостью: " + text;
            case "SAD" -> "Мрачно: " + text;
            default -> text;
        };
    }

    private static String randomState() {
        String[] states = {"HAPPY", "ANGRY", "TIRED", "SAD", "BORED", "INSPIRED"};
        return states[new Random().nextInt(states.length)];
    }
}
