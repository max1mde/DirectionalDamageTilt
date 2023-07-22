/*
 * By MaximDe
 */
package com.maximde.nodamagetilt;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import net.minecraft.network.protocol.game.ClientboundHurtAnimationPacket;

public class PacketListener extends PacketAdapter {

    public PacketListener(NoDamageTilt noDamageTilt) {
        super(noDamageTilt, ListenerPriority.NORMAL, PacketType.Play.Server.HURT_ANIMATION);
    }

    @Override
    public void onPacketReceiving(PacketEvent event) {}

    @Override
    public void onPacketSending(PacketEvent event) {
        if (event.getPacket().getType() == PacketType.Play.Server.HURT_ANIMATION) {
            if (!event.getPlayer().hasPermission("directionaldamagetilt.enable")) return;
            float modifiedYaw = -180.0f;
            ClientboundHurtAnimationPacket modifiedPacket = new ClientboundHurtAnimationPacket(0, modifiedYaw);
            event.setPacket(PacketContainer.fromPacket(modifiedPacket));
        }
    }
}

