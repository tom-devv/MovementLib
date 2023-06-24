package dev.tom.movementlib.MovementTypes;

import dev.tom.movementlib.MovementLib;
import dev.tom.movementlib.MovementTypes.MovementType;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.data.type.Bed;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Bounce extends MovementType {

    public Bounce(Player player, Location loc) {
        super(player, loc);
    }

    @Override
    public void path() {
        Entity entity = getEntity();
        entity.addPassenger(getPlayer());
        new BukkitRunnable(){
            double x = 0;
            @Override
            public void run() {
                double y = (-(Math.pow((x - 20), 2)) / 20);
                entity.removePassenger(getPlayer());
                entity.teleport(new Location(entity.getWorld(), x + 50, y + 50, 0.0));
                entity.addPassenger(getPlayer());
                x = x + 0.5;
                if(x > 50) this.cancel();
            }
        }.runTaskTimer(MovementLib.getInstance(), 0, 1);

    }
}
