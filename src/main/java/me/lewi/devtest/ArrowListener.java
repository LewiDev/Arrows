package me.lewi.devtest;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;


public class ArrowListener implements Listener {

    private Devtest main;

    private BukkitTask returnArrow;

    public ArrowListener(Devtest main) {
        this.main = main;
    }

    @EventHandler
    public void onArrowFire(EntityShootBowEvent e) {
        ItemStack arrowFired = e.getConsumable();

        if(arrowFired.isSimilar(main.getArrowItems().getBundleOfArrows())) {
            // bundleOfArrows
            main.arrowshot.put((Arrow) e.getProjectile(), ArrowType.BUNDLE);
        } else if (arrowFired.isSimilar(main.getArrowItems().getFishArrow())) {
            // FishArrow
            main.arrowshot.put((Arrow) e.getProjectile(), ArrowType.FISH);
        } else if (arrowFired.isSimilar(main.getArrowItems().getDiamondArrow())) {
            // DiamondArrow
            main.arrowshot.put((Arrow) e.getProjectile(), ArrowType.DIAMOND);
        } else if (arrowFired.isSimilar(main.getArrowItems().getInfinityArrow())) {
            // InfinityArrow
            main.arrowshot.put((Arrow) e.getProjectile(), ArrowType.INFINITY);
            main.arrowshooter.put((Arrow) e.getProjectile(), e.getEntity());
        } else if (arrowFired.isSimilar(main.getArrowItems().getEndCrystalArrow())) {
            // EndCrystalArrow
            e.getProjectile().setGravity(false);
        } else {
            return;
        }
    }

    @EventHandler
    public void onArrowLaunch(ProjectileLaunchEvent e) {
        if (!(e.getEntity() instanceof Arrow)) {return;}
        if(!main.arrowshot.containsKey(e.getEntity())) {return;}
        if(main.arrowshot.get(e.getEntity()).equals(ArrowType.BUNDLE)) {
            e.getEntity().getShooter().launchProjectile(Arrow.class);
            e.getEntity().getShooter().launchProjectile(Arrow.class);
            e.getEntity().getShooter().launchProjectile(Arrow.class);
            e.getEntity().getShooter().launchProjectile(Arrow.class);
        }
    }

    @EventHandler
    public void onArrowDamageEntity(EntityDamageByEntityEvent e) {
        if(!(e.getDamager() instanceof Arrow)) {return;}
        if(!main.arrowshot.containsKey(e.getDamager())) {return;}
        if(main.arrowshot.get(e.getDamager()).equals(ArrowType.DIAMOND)) {
            if(e.getDamage() > ((LivingEntity) e.getEntity()).getHealth()) {
                World world = e.getEntity().getWorld();
                Location loc = e.getEntity().getLocation();
                world.dropItemNaturally(loc, main.getDiamondArrowLoot());
            }
        } else if (main.arrowshot.get(e.getDamager()).equals(ArrowType.FISH)) {
            if (!(e.getEntity() instanceof Player) && !(e.getEntity() instanceof Boss)) {
                World world = e.getEntity().getWorld();
                Location loc = e.getEntity().getLocation();
                e.getEntity().remove();
                world.spawnEntity(loc, EntityType.COD);
            }
        } else if (main.arrowshot.get(e.getDamager()).equals(ArrowType.INFINITY)) {
            e.setDamage(e.getDamage() * 3);
            returnArrow = new BukkitRunnable() {
                @Override
                public void run() {
                    LivingEntity entity = (LivingEntity) main.arrowshooter.get(e.getDamager());
                    if (!(entity instanceof Player)) {return;}
                    ((Player) entity).getInventory().addItem(main.getArrowItems().getInfinityArrow());
                }
            }.runTaskLater(main, 40);
        }
    }



}
