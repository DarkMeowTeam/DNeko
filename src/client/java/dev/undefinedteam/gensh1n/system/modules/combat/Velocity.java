package dev.undefinedteam.gensh1n.system.modules.combat;

import dev.undefinedteam.gensh1n.events.client.MovementInputEvent;
import dev.undefinedteam.gensh1n.events.network.PacketEvent;
import dev.undefinedteam.gensh1n.system.modules.Categories;
import dev.undefinedteam.gensh1n.system.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import tech.skidonion.obfuscator.annotations.ControlFlowObfuscation;
import tech.skidonion.obfuscator.annotations.StringEncryption;

@StringEncryption
@ControlFlowObfuscation
public class Velocity extends Module {
    public Velocity() {
        super(Categories.Combat,"velocity","Less or remove knockback");
    }

    int keepTick = 0;

    @EventHandler
    public void onMovementInput(MovementInputEvent event) {
        // jump reset
        // val player = mc.player ?: return
        final ClientPlayerEntity player = mc.player;
        if (player == null) return;

        if (keepTick > 0) {
            keepTick--;

            event.directionalInput.forward = true;
        }
    }

    @EventHandler
    public void onPacket(PacketEvent event) {
        if (event.packet instanceof EntityVelocityUpdateS2CPacket packet) {
            if (mc.player != null && packet.getId() == mc.player.getId()) {
                keepTick = 7;
            }
        }
    }

}
