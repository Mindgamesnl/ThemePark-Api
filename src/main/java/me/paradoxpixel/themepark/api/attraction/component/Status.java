package me.paradoxpixel.themepark.api.attraction.component;

public enum Status {

    CONSTRUCTION, OPEN,
    CLOSED, MAINTENANCE,
    MALFUNCTION, ACTIVE,
    INACTIVE, GLOBAL;

    public static Status getStatus(String string) {
        return valueOf(string);
    }

}
