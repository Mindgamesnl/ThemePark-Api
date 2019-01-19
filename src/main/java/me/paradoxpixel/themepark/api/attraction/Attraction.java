package me.paradoxpixel.themepark.api.attraction;

import me.paradoxpixel.themepark.api.attraction.component.Status;
import me.paradoxpixel.themepark.api.attraction.component.Type;
import me.paradoxpixel.themepark.api.event.attraction.PreStatusChangeEvent;
import me.paradoxpixel.themepark.api.event.attraction.StatusChangeEvent;
import me.paradoxpixel.themepark.api.event.attraction.ChangeAttractionEvent;
import me.paradoxpixel.themepark.api.LocationUtils;
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
        this.status = type.containsStatus(status) ? status : type.getDefault();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(this.name.equals(name))
            return;

        ChangeAttractionEvent event = new ChangeAttractionEvent(this, this.name, name, region_id, region_id, location, location, type, type);
        this.name = name;
        Bukkit.getPluginManager().callEvent(event);
    }

    public String getRegion_id() {
        return region_id;
    }

    public void setRegion_id(String region_id) {
        if(this.region_id.equals(region_id))
            return;

        ChangeAttractionEvent event = new ChangeAttractionEvent(this, name, name, this.region_id, region_id, location, location, type, type);
        this.region_id = region_id;
        Bukkit.getPluginManager().callEvent(event);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        if(location == this.location)
            return;

        if(LocationUtils.toString(location) != null && LocationUtils.toString(location) != null)
            if(LocationUtils.toString(this.location).equals(LocationUtils.toString(location)))
            return;

        ChangeAttractionEvent event = new ChangeAttractionEvent(this, name, name, region_id, region_id, this.location, location, type, type);
        this.location = location;
        Bukkit.getPluginManager().callEvent(event);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        ChangeAttractionEvent event = new ChangeAttractionEvent(this, name, name, region_id, region_id, location, location, this.type, type);
        this.type = type;
        Bukkit.getPluginManager().callEvent(event);
        if(!type.containsStatus(status))
            setStatus(type.getDefault(), null);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status, Player player) {
        if(!type.hasStatus())
            return;

        if(!type.containsStatus(status))
            return;

        if(this.status == status)
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
