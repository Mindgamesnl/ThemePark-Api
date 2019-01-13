package me.paradoxpixel.themepark.api.attraction;

import me.paradoxpixel.themepark.api.attraction.component.Status;
import me.paradoxpixel.themepark.api.attraction.component.Type;
import me.paradoxpixel.themepark.api.event.attraction.PreStatusChangeEvent;
import me.paradoxpixel.themepark.api.event.attraction.StatusChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Attraction {

    private String id, name, region_id;
    private Location location;
    private Type type;
    private Status status;

    public Attraction(String id, String name, String region_id, Location location, Type type, Status status) {
        this.id = id;
        this.name = name;
        this.region_id = region_id;
        this.location = location;
        this.type = type;
        this.status = type.containsStatus(status) ? status : type.getDefefault();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRegion_id() {
        return region_id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Type getType() {
        return type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status, Player player) {
        if(!type.hasStatus())
            return;

        if(!type.containsStatus(status))
            return;

        PreStatusChangeEvent event = new PreStatusChangeEvent(this,  player, this.status, status);
        Bukkit.getPluginManager().callEvent(event);
        if(event.isCancelled())
            return;

        this.status = status;
        StatusChangeEvent e = new StatusChangeEvent(this,  player, this.status, status);
        Bukkit.getPluginManager().callEvent(e);
    }

}
