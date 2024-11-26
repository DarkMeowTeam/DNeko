package dev.undefinedteam.gensh1n.system.modules.movement;

import dev.undefinedteam.gensh1n.events.client.MovementInputEvent;
import dev.undefinedteam.gensh1n.system.modules.Categories;
import dev.undefinedteam.gensh1n.system.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.darkmeow.dneko.inject.accessor.AccessorKeyBinding;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;

public class InventoryMove extends Module {
    public InventoryMove() {
        super(Categories.Movement, "inventory-move", "allow move on any gui");
    }

    @EventHandler
    public void onMovementInput(MovementInputEvent event) {
        if (mc.currentScreen == null) return;

        event.directionalInput.forward = isKeyDownReal(((AccessorKeyBinding) mc.options.forwardKey).getBoundKey().getCode());
        event.directionalInput.back = isKeyDownReal(((AccessorKeyBinding) mc.options.backKey).getBoundKey().getCode());
        event.directionalInput.left = isKeyDownReal(((AccessorKeyBinding) mc.options.leftKey).getBoundKey().getCode());
        event.directionalInput.right = isKeyDownReal(((AccessorKeyBinding) mc.options.rightKey).getBoundKey().getCode());

        event.directionalInput.jumping = isKeyDownReal(((AccessorKeyBinding) mc.options.jumpKey).getBoundKey().getCode());
        event.directionalInput.sneaking = isKeyDownReal(((AccessorKeyBinding) mc.options.sneakKey).getBoundKey().getCode());
    }


    public boolean isKeyDownReal(int keyCode) {
        try {
            return GLFW.glfwGetKey(mc.getWindow().getHandle(), keyCode) == GLFW.GLFW_PRESS;
        } catch (Throwable ignored) {
            return false;
        }
    }
}
