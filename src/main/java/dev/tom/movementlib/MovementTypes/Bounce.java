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

    public Bounce(Player player, Location start, Location end) {
        super(player, start, end);
    }

    @Override
    public void path() {
        Entity entity = getEntity();
        entity.teleport(getStart());
//        entity.addPassenger(getPlayer());
        double step = getStart().getZ() > getDestination().getZ() ? -0.5 : 0.5;

        /*
        The graph is symmetrical about x = 0;
        This means, to go 10 blocks distance, we move from -5 -> +5
        So we divide the distance by two, to get the + and - root
         */

        double root = (getDeltaZ() / 2);

        /*
        Find the translation that will move the graph up so that x +- 5 become the two solutions to the equation
         */
        // This finds the y coordinate when x is at the root
        double yAtX = f(root);

        // To negate this and move it to x = 0 we can simply ( * -1 ) and add the final equation used
        double shift = yAtX * -1;

        new BukkitRunnable(){
            int count = 0;
            double x = 0;
            @Override
            public void run() {
                double y = f(x - root) + shift;
                System.out.println(entity.getLocation().getY());
                entity.removePassenger(getPlayer());
                entity.teleport(
                        new Location(
                                entity.getWorld(),
                                0.0 ,y + getStart().getY(),
                                x
                        )
                );
                // The entity has returned back to y = 0, so it must be at the other root, so its journey has ended
                if(y < 0 && count > 1) {
                    entity.remove();
                    this.cancel();
                }
                entity.addPassenger(getPlayer());
                x = x + (step);
                count++;
                if(count > 200) this.cancel();
            }


        }.runTaskTimer(MovementLib.getInstance(), 0, 1);

    }

    private double f(double x){
        return -(Math.pow(x, 2)) / 50;
    }


}
