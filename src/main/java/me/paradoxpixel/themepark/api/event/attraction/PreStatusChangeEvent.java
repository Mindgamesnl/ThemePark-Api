package me.paradoxpixel.themepark.api.event.attraction;

import me.paradoxpixel.themepark.api.attraction.Attraction;
import me.paradoxpixel.themepark.api.attraction.component.Status;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PreStatusChangeEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private boolean cancel;
    private Attraction attraction;
    private Player player;
    private Status before, after;

    public PreStatusChangeEvent(Attraction attraction, Player player, Status before, Status after) {
        this.attraction = attraction;
        this.player = player;
        this.before = before;
        this.after = after;
        cancel = false;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean b) {
        cancel = b;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public Player getPlayer() {
        return player;
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
