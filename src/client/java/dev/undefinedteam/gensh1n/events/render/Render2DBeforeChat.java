package dev.undefinedteam.gensh1n.events.render;

import dev.undefinedteam.gensh1n.events.SingleThreadEvent;
import net.minecraft.client.gui.DrawContext;

import java.util.ArrayList;
import java.util.List;

public class Render2DBeforeChat implements SingleThreadEvent {
    private static final Render2DBeforeChat INSTANCE = new Render2DBeforeChat();

    public DrawContext drawContext;
    public int width, height;
    public float tickDelta;

    public List<Runnable> postTasks = new ArrayList<>();

    public static Render2DBeforeChat get(DrawContext drawContext, int w, int h, float tickDelta) {
        INSTANCE.drawContext = drawContext;
        INSTANCE.width = w;
        INSTANCE.height = h;
        INSTANCE.tickDelta = tickDelta;
        INSTANCE.postTasks.clear();
        return INSTANCE;
    }

    public void post(Runnable task) {
        this.postTasks.add(task);
    }

    @Override
    public <T extends SingleThreadEvent> T self() {
        return (T) this;
    }
}
