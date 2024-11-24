package net.darkmeow.dneko.inject.accessor;

import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PlayerMoveC2SPacket.class)
public interface AccessorPlayerMoveC2SPacket {

    @Accessor("onGround") boolean getOnGround();
    @Accessor("onGround") void setOnGround(boolean value);

    @Accessor("yaw") float getYaw();
    @Accessor("yaw") void setYaw(float value);

    @Accessor("pitch") float getPitch();
    @Accessor("pitch") void setPitch(float value);

}
