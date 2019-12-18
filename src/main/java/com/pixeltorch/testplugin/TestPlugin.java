package com.pixeltorch.testplugin;

import com.pixeltorch.testplugin.Events.OnDeath;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Test Plugin has started up successfully!");
        getServer().getPluginManager().registerEvents(new OnDeath(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Test Plugin has shut down successfully!");
    }
}
