package net.darkmeow.dneko.inject.accessor;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ItemGroups.class)
public interface AccessorItemGroups {

    @Accessor("INVENTORY")
    static RegistryKey<ItemGroup> getInventory() {
        throw new AssertionError(); // Mixin 会在运行时注入实际方法体
    }
}
