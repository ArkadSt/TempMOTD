package org.arkadst.tempmotd;

import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class EventListener implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent event){
        event.motd(LegacyComponentSerializer.legacyAmpersand().deserialize(Main.MOTD));
    }

}
