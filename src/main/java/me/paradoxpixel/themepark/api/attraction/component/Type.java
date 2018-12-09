package me.paradoxpixel.themepark.api.attraction.component;

public enum Type {

    RIDE(true, Status.CLOSED, Status.CONSTRUCTION, Status.OPEN, Status.CLOSED, Status.MAINTENANCE, Status.MALFUNCTION),
    SHOW(true, Status.CLOSED, Status.CONSTRUCTION, Status.ACTIVE, Status.INACTIVE),
    GLOBAL(false, Status.GLOBAL);

    private boolean status;
    private Status def;
    private Status[] array;

    Type(boolean status, Status def, Status... array) {
        this.status = status;
        this.def = def;
        this.array = array;
    }

    public boolean hasStatus() {
        return status;
    }

    public Status getDefefault() {
        return def;
    }

    public boolean containsStatus(Status status) {
        if(status == null)
            return false;

        if(!hasStatus())
            return false;

        for(int i = 0; i < array.length; i++)
            if(array[i] == status)
                return true;

        return false;
    }


    public static Type getType(String string) {
        if(string == null)
            return null;

        string = string.toUpperCase();
        switch(string) {
            case "RIDE":
                return Type.RIDE;
            case "SHOW":
                return Type.SHOW;
            case "GLOBAL":
                return Type.GLOBAL;
            default:
                return null;
        }
    }

}
