package me.guamencja.sgsmp;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Utils extends JavaPlugin {

    private static Utils instance;

    public static Utils getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        Listener cancelHpRegenEvent = new HpRegen();
        getServer().getPluginManager().registerEvents(cancelHpRegenEvent, this);
        HpRegen.newRegenTask();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
