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
//            Location endingLocation = new Location(e.getPlayer().getWorld(), 0 , 2 , 40);
//            Location location = new Location(e.getPlayer().getWorld(), 0, 2, 0);
//            new Bounce(e.getPlayer(), location, endingLocation).path();
            MathHelper.QuadraticEquationSolver(0, 2, 5,40);
            // 0,2 ^ ->
            // 5, 40
        }
    }


    @Override
    public void onDisable() {
    }

    public static MovementLib getInstance() {
        return instance;
    }
}
