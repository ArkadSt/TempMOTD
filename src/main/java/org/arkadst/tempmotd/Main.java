package org.arkadst.tempmotd;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main extends JavaPlugin {

    public static String MOTD;
    public File motdtxt;

    @Override
    public void onEnable() {
        if (!getDataFolder().exists()){
            getDataFolder().mkdir();
        }
        motdtxtReload();

        getServer().getPluginManager().registerEvents(new EventListener(), this);

        getCommand("tempmotd").setExecutor(new TempMOTDCommand(this));
        getCommand("setmotd").setExecutor(new SetMOTDCommand(this));
    }

    @Override
    public void onDisable() {

    }

    public void motdtxtReload(){
        motdtxt = new File(getDataFolder(), "motd.txt");
        MOTD = "";

        try {
            Scanner motd_reader = new Scanner(motdtxt);
            while (motd_reader.hasNextLine()) {
                MOTD += motd_reader.nextLine();
            }
            motd_reader.close();
        } catch (FileNotFoundException e) {
            getLogger().info("motd.txt does not exist.");
        }
    }
}
