package dev.undefinedteam.gensh1n.events.client;

import dev.undefinedteam.gensh1n.events.Cancellable;
import net.minecraft.client.option.GameOptions;

public class MovementInputEvent extends Cancellable {
    public DirectionalInput directionalInput;

    public MovementInputEvent(DirectionalInput directionalInput) {
        this.directionalInput = directionalInput;
    }

    public static class DirectionalInput {
        public boolean forward;
        public boolean back;
        public boolean left;
        public boolean right;
        public boolean jumping;
        public boolean sneaking;

        public DirectionalInput(GameOptions settings) {
            forward = settings.forwardKey.isPressed();
            back = settings.backKey.isPressed();
            left = settings.leftKey.isPressed();
            right = settings.rightKey.isPressed();
            jumping = settings.jumpKey.isPressed();
            sneaking = settings.sneakKey.isPressed();
        }
    }
}
