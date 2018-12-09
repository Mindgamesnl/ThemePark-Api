package me.paradoxpixel.themepark.api.event.attraction;

import me.paradoxpixel.themepark.api.attraction.Attraction;
import me.paradoxpixel.themepark.api.attraction.component.Status;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class StatusChangeEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private Attraction attraction;
    private Status before, after;

    public StatusChangeEvent(Attraction attraction, Status before, Status after) {
        this.attraction = attraction;
        this.before = before;
        this.after = after;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public Status getStatusBefore() {
        return before;
    }

    public Status getStatusAfter() {
        return after;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
