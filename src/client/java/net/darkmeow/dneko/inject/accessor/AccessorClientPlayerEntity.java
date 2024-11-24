package net.darkmeow.dneko.inject.accessor;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ClientPlayerEntity.class)
public interface AccessorClientPlayerEntity extends AccessorAbstractClientPlayerEntity {

    @Accessor("lastX") double getLastX();

    @Accessor("lastZ") double getLastZ();
}
