package me.paradoxpixel.themepark.api.event.region;

import me.paradoxpixel.themepark.api.attraction.Region;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import java.util.List;

public class ChangeRegionEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private Region region;
    private String bname, aname;
    private List<String> blore, alore;

    public ChangeRegionEvent(Region region, String bname, String aname, List<String> blore, List<String> alore) {
        this.region = region;
        this.bname = bname;
        this.aname = aname;
        this.blore = blore;
        this.alore = alore;
    }

    public Region getRegion() {
        return region;
    }

    public String getNameBefore() {
        return bname;
    }

    public String getNameAfter() {
        return aname;
    }

    public List<String> getLoreBefore() {
        return blore;
    }

    public List<String> getLoreAfter() {
        return alore;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}

