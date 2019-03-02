package me.paradoxpixel.themepark.api;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationUtils {

    public static String toString(Location location) {
        if(location == null)
            return null;

        World world = location.getWorld();
        if(world == null)
            return null;

        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();

        String string = world.getName() + ":" + x + ":" + y + ":" + z;
        if(location.getYaw() != 0 || location.getPitch() != 0)
            string += ":" + location.getYaw() + ":" + location.getPitch();

        return string;
    }

    public static Location toLocation(String string) {
        if(string == null)
            return null;

        String[] args = string.split(":");
        if(args.length < 4)
            return null;

        World world = Bukkit.getWorld(args[0]);
        if(world == null)
            return null;

        double x = Double.parseDouble(args[1]);
        double y = Double.parseDouble(args[2]);
        double z = Double.parseDouble(args[3]);

        Location location = new Location(world, x, y, z);
        if(args.length < 6)
            return location;

        float yaw = Float.parseFloat(args[4]);
        float pitch = Float.parseFloat(args[5]);
        location.setYaw(yaw);
        location.setPitch(pitch);

        return location;
    }

}
