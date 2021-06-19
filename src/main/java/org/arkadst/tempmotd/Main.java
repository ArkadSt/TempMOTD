package org.arkadst.tempmotd;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class Main extends JavaPlugin {

    public static FileConfiguration config;

    @Override
    public void onEnable() {
        if (!(new File(getDataFolder(), "config.yml")).exists()) {
            saveDefaultConfig();
        }

        config = getConfig();

        getServer().getPluginManager().registerEvents(new EventListener(), this);

        getCommand("tempmotd").setExecutor(new TempMOTDCommand(this));
        getCommand("setmotd").setExecutor(new SetMOTDCommand(this));
    }

    @Override
    public void onDisable() {

    }

}
