package dev.tom.movementlib;

import dev.tom.movementlib.MovementTypes.Bounce;
import dev.tom.movementlib.MovementTypes.MovementType;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MovementLib extends JavaPlugin implements Listener {


    public static MovementLib instance;

    // Testing only
    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void aa(PlayerInteractEvent e){
        if(e.getPlayer().getItemInHand().getType().equals(Material.BONE)){
            Location location = e.getPlayer().getLocation();
            Location endingLocation = location.add(0,0,10);
            Bounce bounce = new Bounce(e.getPlayer(), endingLocation);
            bounce.path();
        }
    }


//    @EventHandler
//    public void onMove(PlayerMoveEvent e){
//        Location location = e.getPlayer().getLocation();
//        if(location.distanceSquared(new Location(e.getPlayer().getWorld(), -34,-60,118)) < 0.8){
//            Location endingLocation = location.add(0,0,5);
//            Bounce bounce = new Bounce(e.getPlayer(), endingLocation);
//            bounce.path();
//        }
//    }

    @Override
    public void onDisable() {
    }

    public static MovementLib getInstance() {
        return instance;
    }
}
