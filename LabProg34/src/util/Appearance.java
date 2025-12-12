package util;

public record Appearance(String description, String clothing) {
    @Override
    public String toString() {
        return description + ", одет в " + clothing;
    }

}