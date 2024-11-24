package net.darkmeow.dneko.inject.accessor;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.PlayerListEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(AbstractClientPlayerEntity.class)
public interface AccessorAbstractClientPlayerEntity {

    @Invoker("getPlayerListEntry")
    PlayerListEntry dNeko_getPlayerListEntry();

}