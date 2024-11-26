package net.darkmeow.dneko.inject.mixin;

import dev.undefinedteam.gensh1n.Client;
import dev.undefinedteam.gensh1n.events.client.MovementInputEvent;
import net.minecraft.client.input.KeyboardInput;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(KeyboardInput.class)
public class MixinKeyboardInput {

    /*
        @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/KeyBinding;isPressed()Z"))
    private boolean hookInventoryMove(KeyBinding keyBinding) {
        return ModuleInventoryMove.INSTANCE.shouldHandleInputs(keyBinding)
                ? InputTracker.INSTANCE.isPressedOnAny(keyBinding) : keyBinding.isPressed();
    }

    @Inject(method = "tick", at = @At(value = "FIELD", target = "Lnet/minecraft/client/input/KeyboardInput;pressingBack:Z", ordinal = 0))
    private void hookInventoryMoveSprint(boolean slowDown, float f, CallbackInfo ci) {
        if (ModuleInventoryMove.INSTANCE.shouldHandleInputs(this.settings.sprintKey)) {
            this.settings.sprintKey.setPressed(InputTracker.INSTANCE.isPressedOnAny(this.settings.sprintKey));
        }
    }
     */
    @Shadow
    @Final
    private GameOptions settings;

    @Unique
    public MovementInputEvent dNeko$event;

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/KeyBinding;isPressed()Z", ordinal = 0))
    private boolean tick$redirect$forward(KeyBinding instance) {
        dNeko$event = new MovementInputEvent(new MovementInputEvent.DirectionalInput(this.settings));
        Client.EVENT_BUS.post(dNeko$event);

        return dNeko$event.directionalInput.forward;
    }

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/KeyBinding;isPressed()Z", ordinal = 1))
    private boolean tick$redirect$back(KeyBinding instance) {
        return dNeko$event.directionalInput.back;
    }

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/KeyBinding;isPressed()Z", ordinal = 2))
    private boolean tick$redirect$left(KeyBinding instance) {
        return dNeko$event.directionalInput.left;
    }

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/KeyBinding;isPressed()Z", ordinal = 3))
    private boolean tick$redirect$right(KeyBinding instance) {
        return dNeko$event.directionalInput.right;
    }

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/KeyBinding;isPressed()Z", ordinal = 4))
    private boolean tick$redirect$jumping(KeyBinding instance) {
        return dNeko$event.directionalInput.jumping;
    }

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/KeyBinding;isPressed()Z", ordinal = 5))
    private boolean tick$redirect$sneaking(KeyBinding instance) {
        return dNeko$event.directionalInput.sneaking;
    }

}
