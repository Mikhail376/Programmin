package util;

public record Appearance(String description, String clothing) {
    @Override
    public String toString() {
        return "Appearance{description='" + description + "', clothing='" + clothing + "'}";
    }
}