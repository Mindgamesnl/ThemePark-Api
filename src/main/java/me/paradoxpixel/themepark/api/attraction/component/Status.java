package me.paradoxpixel.themepark.api.attraction.component;

public enum Status {

    CONSTRUCTION, OPEN,
    CLOSED, MAINTENANCE,
    MALFUNCTION, ACTIVE,
    INACTIVE, GLOBAL;

    public static Status getStatus(String string) {
        if(string == null)
            return null;

        string = string.toUpperCase();
        switch(string) {
            case "CONSTRUCTION":
                return Status.CONSTRUCTION;
            case "OPEN":
                return Status.OPEN;
            case "CLOSED":
                return Status.CLOSED;
            case "MAINTENANCE":
                return Status.MAINTENANCE;
            case "MALFUNCTION":
                return Status.MALFUNCTION;
            case "ACTIVE":
                return Status.ACTIVE;
            case "INACTIVE":
                return Status.INACTIVE;
            default:
                return null;
        }
    }

}
