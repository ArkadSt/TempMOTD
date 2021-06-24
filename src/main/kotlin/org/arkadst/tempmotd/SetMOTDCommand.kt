package org.arkadst.tempmotd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SetMOTDCommand implements CommandExecutor {

    Main main;
    public SetMOTDCommand(Main main){
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length >= 1) {
            StringBuilder message = new StringBuilder();
            for (int x = 1; x < args.length; x++) {
                message.append(args[x]);
                if (x != args.length - 1) {
                    message.append(" ");
                }
            }

            try{
                int row = Integer.parseInt(args[0]);

                if (row == 1 || row == 2){
                    List<String> motd = Main.config.getStringList("motd");
                    motd.set(row - 1, message.toString());
                    Main.config.set("motd", motd);
                    main.saveConfig();
                    main.reloadConfig();
                } else {
                    return false;
                }
            }catch (NumberFormatException e){
                return false;
            }

        }
        return true;
    }
}
