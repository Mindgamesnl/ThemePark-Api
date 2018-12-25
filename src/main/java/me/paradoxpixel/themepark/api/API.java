package me.paradoxpixel.themepark.api;

import me.paradoxpixel.themepark.api.attraction.Attraction;
import me.paradoxpixel.themepark.api.attraction.Region;
import me.paradoxpixel.themepark.api.event.attraction.AddAttractionEvent;
import me.paradoxpixel.themepark.api.event.attraction.RemoveAttractionEvent;
import me.paradoxpixel.themepark.api.event.region.AddRegionEvent;
import me.paradoxpixel.themepark.api.event.region.RemoveRegionEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class API {

    private static LinkedHashMap<String, Region> regions = new LinkedHashMap<>();
    private static LinkedHashMap<String, Attraction> attractions = new LinkedHashMap<>();

    public static void addRegion(Region region) {
        if(isRegion(region.getId()))
            return;

        if(regions.size() >= 6)
            return;

        region = toLower(region);
        regions.put(region.getId(), region);

        AddRegionEvent event = new AddRegionEvent(region);
        Bukkit.getPluginManager().callEvent(event);
    }

    public static boolean isRegion(String id) {
        return regions.containsKey(id.toLowerCase());
    }

    public static boolean isRegionFull(String id) {
        if(!isRegion(id))
            return false;

        return getRegion(id).getAttractions().size() >= 8;
    }

    public static Region getRegion(String id) {
        return regions.get(id.toLowerCase());
    }

    public static HashMap<String, Region> getRegions() {
        return new LinkedHashMap<>(regions);
    }

    public static void removeRegion(String id) {
        if(!isRegion(id))
            return;

        HashMap<String, Attraction> map = new HashMap<>(attractions);
        for(Map.Entry<String, Attraction> entry : map.entrySet()) {
            Attraction attraction = entry.getValue();
            if(!attraction.getRegion_id().equalsIgnoreCase(id))
                continue;

            removeAttraction(attraction.getId());
        }

        RemoveRegionEvent event = new RemoveRegionEvent(getRegion(id));
        Bukkit.getPluginManager().callEvent(event);
        regions.remove(id.toLowerCase());
    }

    public static void addAttraction(Attraction attraction) {
        if(!isRegion(attraction.getRegion_id()))
            return;

        if(isRegionFull(attraction.getRegion_id()))
            return;

        if(isAttraction(attraction.getId()))
            return;

        attraction = toLower(attraction);
        getRegion(attraction.getRegion_id()).addAttraction(attraction);
        attractions.put(attraction.getId(), attraction);

        AddAttractionEvent event = new AddAttractionEvent(attraction);
        Bukkit.getPluginManager().callEvent(event);
    }

    public static boolean isAttraction(String id) {
        return attractions.containsKey(id.toLowerCase());
    }

    public static Attraction getAttraction(String id) {
        return attractions.get(id.toLowerCase());
    }

    public static Attraction getAttractionFromName(String name) {
        for(Attraction attraction : attractions.values()) {
            if(!color(attraction.getName()).equals(name))
                continue;

            return attraction;
        }

        return null;
    }

    public static HashMap<String, Attraction> getAttractions() {
        return new LinkedHashMap<>(attractions);
    }

    public static void removeAttraction(String id) {
        if(!isAttraction(id))
            return;

        Attraction attraction = getAttraction(id);
        if(isRegion(attraction.getRegion_id()))
            getRegion(attraction.getRegion_id()).removeAttraction(attraction);

        attractions.remove(id.toLowerCase());

        RemoveAttractionEvent event = new RemoveAttractionEvent(attraction);
        Bukkit.getPluginManager().callEvent(event);
    }

    private static Region toLower(Region region) {
        Region re = new Region(region.getId().toLowerCase(),
                region.getName(),
                region.getLore());

        re.setAttractions(region.getAttractions());
        return re;
    }

    private static Attraction toLower(Attraction attraction) {
        return new Attraction(attraction.getId().toLowerCase(),
                attraction.getName(),
                attraction.getRegion_id().toLowerCase(),
                attraction.getLocation(),
                attraction.getType(),
                attraction.getStatus());
    }

    private static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

}
