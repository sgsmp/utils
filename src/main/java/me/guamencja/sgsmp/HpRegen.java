package me.guamencja.sgsmp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getServer;

public class HpRegen implements Listener {
    @EventHandler (priority = EventPriority.MONITOR)
    public void onHpRegen(EntityRegainHealthEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }

        e.setCancelled(true);
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "EntityRegainHealthEvent canceled");
    }

    public static void newRegenTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for(final Player p : new ArrayList<>(getServer().getOnlinePlayers())) {
                    final double health = p.getHealth();
                    if (!(health < p.getMaxHealth())) return;
                    Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "+0.1");
                    p.setHealth(p.getHealth() + 0.5);
                }
            }
        }.runTaskTimer(Utils.getInstance(), 0L, (long) (2*60*20L));
    }
}
