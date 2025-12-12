package persons;

import java.util.Objects;


public abstract class Person {
    protected String name;
    protected String state;

    public Person(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    protected abstract String styleSpeech(String text);

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{name='" + name + "', state='" + state + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(state, person.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, state);
    }
}
