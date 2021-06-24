package org.arkadst.tempmotd

import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import org.bukkit.configuration.file.FileConfiguration

class Main : JavaPlugin() {
    override fun onEnable() {
        if (!File(dataFolder, "config.yml").exists()) {
            saveDefaultConfig()
        }
        Companion.configuration = config
        server.pluginManager.registerEvents(EventListener(), this)
        getCommand("tempmotd")!!.setExecutor(TempMOTDCommand(this))
        getCommand("setmotd")!!.setExecutor(SetMOTDCommand(this))
    }

    override fun onDisable() {}


    companion object {
        lateinit var configuration: FileConfiguration
    }
}