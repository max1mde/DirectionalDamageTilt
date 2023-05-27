/*
 * By MaximDe
 */

package com.maximde.nodamagetilt;

import com.comphenix.protocol.ProtocolLibrary;
import org.bukkit.plugin.java.JavaPlugin;

public class NoDamageTilt extends JavaPlugin {
    @Override
    public void onEnable() {
        PacketListener hurtAnimation = new PacketListener(this);
        ProtocolLibrary.getProtocolManager().addPacketListener(hurtAnimation);
    }

    @Override
    public void onDisable() {
        ProtocolLibrary.getProtocolManager().removePacketListeners(this);
    }
}
