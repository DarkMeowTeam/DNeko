package net.darkmeow.dneko.inject.accessor;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BucketItem.class)
public interface AccessorBucketItem {

    @Accessor("fluid")
    Fluid getFluid();
}
