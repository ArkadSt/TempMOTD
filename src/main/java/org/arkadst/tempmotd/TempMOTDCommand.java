package org.arkadst.tempmotd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class TempMOTDCommand implements CommandExecutor {

    Main main;

    public TempMOTDCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            switch (args[0]) {
                case "reload":
                    main.motdtxtReload();
                    sender.sendMessage(ChatColor.GREEN + "[TempMOTD] motd.txt was reloaded successfully");
                    break;
                default:
                    sender.sendMessage(ChatColor.RED + "[TempMOTD] No such command.");
                    break;
            }

        } else {
            sender.sendMessage(ChatColor.RED + "[TempMOTD] No such command.");
        }
        return true;
    }
}
