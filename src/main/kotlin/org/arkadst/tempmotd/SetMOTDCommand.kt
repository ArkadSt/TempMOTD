package org.arkadst.tempmotd

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import java.lang.StringBuilder
import java.lang.NumberFormatException

class SetMOTDCommand(private val main: Main) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        val motd = main.config.getStringList("motd")
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
                    main.config.set("motd", motd)
                    main.saveConfig()
                    main.reloadConfig()
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