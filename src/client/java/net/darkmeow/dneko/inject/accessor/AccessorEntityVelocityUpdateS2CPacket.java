package net.darkmeow.dneko.inject.accessor;

import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(EntityVelocityUpdateS2CPacket.class)
public interface AccessorEntityVelocityUpdateS2CPacket {

    @Accessor("velocityX")
    void setVelocityX(int value);

    @Accessor("velocityZ")
    void setVelocityZ(int value);


}
