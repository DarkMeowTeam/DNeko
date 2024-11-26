package dev.undefinedteam.gensh1n.mixins;

import dev.undefinedteam.gensh1n.system.modules.Modules;
import dev.undefinedteam.gensh1n.system.modules.misc.Protocol;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.network.ClientLoginNetworkHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientLoginNetworkHandler.class)
public class MixinClientLoginNetworkHandler {
    @Redirect(method = "onSuccess", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/ClientBrandRetriever;getClientModName()Ljava/lang/String;"))
    private String getClientModName() {
        return Modules.get().get(Protocol.class).isHeypixel() ? "forge" : ClientBrandRetriever.getClientModName();
    }
}
