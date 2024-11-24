package net.darkmeow.dneko.inject.accessor;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.PendingUpdateManager;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ClientWorld.class)
public interface AccessorClientWorld {

    @Invoker("getPendingUpdateManager") PendingUpdateManager dNeko_getPendingUpdateManager();

}
