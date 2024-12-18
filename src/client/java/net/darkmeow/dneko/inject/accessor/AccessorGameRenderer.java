package net.darkmeow.dneko.inject.accessor;

import net.minecraft.client.render.GameRenderer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GameRenderer.class)
public interface AccessorGameRenderer {

    @Invoker("loadPostProcessor")
    void dNeko_loadPostProcessor(Identifier id);
}
