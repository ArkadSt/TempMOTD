package org.arkadst.tempmotd

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class TempMOTDCommand(private val main: Main) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (args.size == 1) {
            when (args[0]) {
                "reload" -> {
                    main.reloadConfig()
                    sender.sendMessage(ChatColor.GREEN.toString() + "[TempMOTD] Configuration was reloaded successfully.")
                }
                else -> {
                    sender.sendMessage(ChatColor.RED.toString() + "[TempMOTD] No such command.")
                }
            }
        } else {
            sender.sendMessage(ChatColor.RED.toString() + "[TempMOTD] No such command.")
        }
        return true
    }
}