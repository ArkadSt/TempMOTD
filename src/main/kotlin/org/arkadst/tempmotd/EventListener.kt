package org.arkadst.tempmotd

import org.bukkit.event.server.ServerListPingEvent
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class EventListener : Listener {

    @EventHandler
    fun onPing(event: ServerListPingEvent) {
        val motd = Main.configuration.getStringList("motd")
        event.motd(LegacyComponentSerializer.legacyAmpersand().deserialize("${motd[0]}\n${motd[1]}"))
    }
}