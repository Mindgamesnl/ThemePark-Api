package me.paradoxpixel.themepark.api.event.attraction;

import me.paradoxpixel.themepark.api.attraction.Attraction;
import me.paradoxpixel.themepark.api.attraction.component.Type;
import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ChangeAttractionEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private Attraction attraction;
    private String bname, aname, bregion_id, aregion_id;
    private Location blocation, alocation;
    private Type btype, atype;

    public ChangeAttractionEvent(Attraction attraction,
                                 String bname, String aname,
                                 String aregion_id, String bregion_id,
                                 Location alocation, Location blocation,
                                 Type btype, Type atype) {
        this.attraction = attraction;
        this.bname = bname;
        this.aname = aname;
        this.bregion_id = bregion_id;
        this.aregion_id = aregion_id;
        this.alocation = alocation;
        this.blocation = blocation;
        this.btype = btype;
        this.atype = atype;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public String getNameBefore() {
        return bname;
    }

    public String getNameAfter() {
        return aname;
    }

    public String getRegionIdBefore() {
        return bregion_id;
    }

    public String getRegionIdAfter() {
        return aregion_id;
    }

    public Location getLocationBefore() {
        return blocation;
    }

    public Location getLocationAfter() {
        return alocation;
    }

    public Type getTypeBefore() {
        return btype;
    }

    public Type getTypeAfter() {
        return atype;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}

