package dev.tom.movementlib.MovementTypes;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public abstract class MovementType {

    private final Player player;
    private final Location start;
    private final Location destination;
    private double duration;

    public MovementType(Player player,  Location location){
        this.start = player.getLocation();
        this.player = player;
        this.destination = location;
        this.duration = 1.0;
    }

    /**
     * Defines how the movement should act
     */
    public void path(){

    }

    public Entity getEntity (){
        ArmorStand armorStand = getStart().getWorld().spawn(getStart(), ArmorStand.class);
        armorStand.setInvisible(true);
//        armorStand.setInvulnerable(true);
        armorStand.setGravity(false);
//        armorStand.setMarker(true);
        return armorStand;
    }

    public double getDeltaX(){
        return getStart().getBlockX() - getDestination().getBlockX();
    }

    public double getDeltaY(){
        return getStart().getBlockY() - getDestination().getBlockY();
    }

    public double getDeltaZ(){
        return getStart().getBlockZ() - getDestination().getBlockZ();
    }



    public Location getStart() {
        return start;
    }

    public Location getDestination() {
        return destination;
    }

    public Player getPlayer() {
        return player;
    }

    /**
     * Set how long the entire movement should last for
     * @param duration
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getDuration() {
        return duration;
    }
}
