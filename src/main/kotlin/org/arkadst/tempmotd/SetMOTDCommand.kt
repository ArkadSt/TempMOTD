package org.arkadst.tempmotd

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import java.lang.StringBuilder
import java.lang.NumberFormatException

class SetMOTDCommand(private var main: Main) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        val motd = Main.configuration.getStringList("motd")
        if (args.isNotEmpty()) {
            val message = StringBuilder()
            for (x in 1 until args.size) {
                message.append(args[x])
                if (x != args.size - 1) {
                    message.append(" ")
                }
            }
            try {
                val row = args[0].toInt()
                if (row == 1 || row == 2) {
                    motd[row - 1] = message.toString()
                    Main.configuration.set("motd", motd)
                    main.saveConfig()
                    main.reloadConfig()
                    Main.configuration = main.config
                } else {
                    return false
                }
            } catch (e: NumberFormatException) {
                return false
            }
        } else {
            return false
        }
        return true
    }
}