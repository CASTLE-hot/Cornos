package me.constantindev.ccl.module;

import me.constantindev.ccl.etc.base.Module;
import net.minecraft.client.MinecraftClient;

public class MoonGravity extends Module {
    public MoonGravity() {
        super("MoonGravity", "Makes you go weee");
    }

    @Override
    public void onExecute() {
        MinecraftClient.getInstance().player.addVelocity(0, 0.0568000030517578, 0); // Yes, this was precisely calculated.
        super.onExecute();
    }
}