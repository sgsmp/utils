package me.guamencja.sgsmp;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class BedEnter implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onBedEnter(PlayerBedEnterEvent e) {
        Player p = e.getPlayer();
        if (!(p.getFoodLevel() < 10.0)) return;

        e.setCancelled(true);
        p.sendMessage(ChatColor.RED + "Nie możesz położyć się spać, gdy jesteś głodny!");
    }
}
