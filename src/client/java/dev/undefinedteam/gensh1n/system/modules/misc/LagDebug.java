package dev.undefinedteam.gensh1n.system.modules.misc;

import dev.undefinedteam.gensh1n.events.network.PacketEvent;
import dev.undefinedteam.gensh1n.system.modules.Categories;
import dev.undefinedteam.gensh1n.system.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;

public class LagDebug extends Module {

    public LagDebug() {
        super(Categories.Misc, "lag-debug", "display lag info");
    }

    public int count = 0;

    @Override
    public void toggle() {
        count = 0;
        super.toggle();
    }

    @EventHandler
    public void onPacket(PacketEvent event) {
        if (event.packet instanceof PlayerPositionLookS2CPacket packet) {
            count++;
            nInfo("[LagDebug] Lag x" + count, NSHORT);
        }
    }
}
