package me.paradoxpixel.themepark.api.attraction;

import me.paradoxpixel.themepark.api.event.region.ChangeRegionEvent;
import org.bukkit.Bukkit;
import java.util.ArrayList;
import java.util.List;

public class Region {

    private String id, name;
    private List<String> lore;
    private ArrayList<Attraction> attractions;

    public Region(String id, String name, List<String> lore) {
        this.id = id;
        this.name = name;
        this.lore = lore;
        this.attractions = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String string) {
        if(string == null || string.equals(""))
            return;

        String old = name;
        name = string;

        ChangeRegionEvent event = new ChangeRegionEvent(this, old, string, lore, lore);
        Bukkit.getPluginManager().callEvent(event);
    }

    public List<String> getLore() {
        return lore;
    }

    public void setLore(List<String> lore) {
        List<String> old = lore;
        this.lore = lore;

        ChangeRegionEvent event = new ChangeRegionEvent(this, name, name, old, lore);
        Bukkit.getPluginManager().callEvent(event);
    }

    public void setLore(int i, String string) {
        if(lore.size() >= 4 || i >= 4)
            return;

        List<String> old = lore;
        lore = new ArrayList<>();
        lore.addAll(old);

        if(!string.equals("NULL")) {
            if (lore.size() >= i)
                for (int a = 0; a <= (i - lore.size()); a++)
                    lore.add(" ");

            lore.set(i, string);
        } else {
            lore.remove(i);
        }

        ChangeRegionEvent event = new ChangeRegionEvent(this, name, name, old, lore);
        Bukkit.getPluginManager().callEvent(event);
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(ArrayList<Attraction> attractions) {
        this.attractions = attractions;
    }

    public void addAttraction(Attraction attraction) {
        if(!isAttraction(attraction))
            attractions.add(attraction);
    }

    public boolean isAttraction(Attraction attraction) {
        return attractions.contains(attraction);
    }

    public void removeAttraction(Attraction attraction) {
        if(isAttraction(attraction))
            attractions.remove(attraction);
    }

}
