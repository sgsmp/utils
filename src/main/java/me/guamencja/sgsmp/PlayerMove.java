package me.guamencja.sgsmp;

import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerMove implements Listener {
    private final int lightThreshold = 5;

    @EventHandler (priority = EventPriority.MONITOR)
    public void onPlayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (isDark(p.getLocation(), p.getInventory())) {
            // side effects
            p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 1));
        } else if(p.hasPotionEffect(PotionEffectType.BLINDNESS)) {
            p.removePotionEffect(PotionEffectType.BLINDNESS);
        }
    }

    private boolean isDark(Location location, PlayerInventory inventory) {
        World world = location.getWorld();
        if (world == null) return false;

        ItemStack mainHandItem = inventory.getItemInMainHand();
        ItemStack secondHandItem = inventory.getItemInOffHand();
        if (secondHandItem.getType() == Material.TORCH || mainHandItem.getType() == Material.TORCH) return false;
        if (location.getBlock().getLightLevel() >= lightThreshold) return false;
        //Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "getLightLevel(): " + location.getBlock().getLightLevel());
        //Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "getLightFromBlocks(): " + location.getBlock().getLightFromBlocks());
        //Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "getLightFromSky(): " + location.getBlock().getLightFromSky());


        return true;
    }
}
