package me.paradoxpixel.themepark.api.event.region;

import me.paradoxpixel.themepark.api.attraction.Region;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AddRegionEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private Region region;

    public AddRegionEvent(Region region) {
        this.region = region;
    }

    public Region getRegion() {
        return region;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}

