package me.paradoxpixel.themepark.api.event.attraction;

import me.paradoxpixel.themepark.api.attraction.Attraction;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class RemoveAttractionEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private Attraction attraction;

    public RemoveAttractionEvent(Attraction attraction) {
        this.attraction = attraction;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}