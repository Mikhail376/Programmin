package persons;

public class MrKrabs extends Person {

    public MrKrabs() {
        super("MrKrabs", "NEUTRAL");
    }

    public void enterOffice(Grizel editor) {
        String edState = editor.getState();
        if ("ANGRY".equals(edState) || "TIRED".equals(edState) && Math.random() < 0.3) {
            throw new exceptions.EditorNotFoundException("Редактор отказался принимать материалы: он устал и ушёл отдыхать. Он" + edState);
        }
        System.out.println("MrKrabs: Вошёл в офис редактора.");
        editor.greetVisitor();
    }

    @Override
    protected String styleSpeech(String text) {
        return switch (state) {
            case "HAPPY" -> "радостно: " + text;
            case "ANGRY" -> "сердито: " + text;
            case "TIRED" -> "э: " + text;
            case "SAD" -> "грустно: " + text;
            default -> text;
        };
    }
    @Override
    public String toString() {
        return "Мистер Крабс (состояние: " + state + ")";
    }

}
