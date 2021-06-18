package org.arkadst.tempmotd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.io.FileWriter;
import java.io.IOException;

public class SetMOTDCommand implements CommandExecutor {

    Main main;
    public SetMOTDCommand(Main main){
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length >= 1){
            StringBuilder message = new StringBuilder();
            for (int x = 0; x < args.length; x++){
                message.append(args[x]);
                if (x != args.length - 1){
                    message.append(" ");
                }
            }
            Main.MOTD = message.toString();

            try {
                FileWriter isOp_file_writer = new FileWriter(main.motdtxt);
                isOp_file_writer.write(Main.MOTD);
                isOp_file_writer.close();
            } catch (IOException e){
                e.printStackTrace();
            }

        } else {
            Main.MOTD = "";
            main.motdtxt.delete();
        }
        return true;
    }
}
