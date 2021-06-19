package org.arkadst.tempmotd;

import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.util.List;

public class EventListener implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent event){
        List<String> motd = Main.config.getStringList("motd");
        event.motd(LegacyComponentSerializer.legacyAmpersand().deserialize(motd.get(0) + '\n' + motd.get(1)));
    }

}
