package dev.tom.movementlib.Regions;

import org.bukkit.Location;
import org.bukkit.World;

public class MovementRegion {

    private Location loc1;
    private Location loc2;
    private World world;

    public MovementRegion(int x1, int y1, int z1, int x2, int y2, int z2, World world) {
        Location loc1 = new Location(world,x1,y1,z1);
        Location loc2 = new Location(world,x2,y2,z2);
        this.world = world;
    }

    public MovementRegion(Location loc1, Location loc2){
        this.loc1 = loc1;
        this.loc2 = loc2;
        // Can't set a region between two worlds
        if(loc1.getWorld() != loc2.getWorld()){
            this.world = null;
        }
        this.world = loc1.getWorld();
    }


    public World getWorld() {
        return world;
    }
}
