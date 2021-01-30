package me.constantindev.ccl.module;

import me.constantindev.ccl.etc.base.Module;
import me.constantindev.ccl.etc.config.ModuleConfig;
import net.minecraft.client.MinecraftClient;

public class Test extends Module {
    public Test() {
        super("Test", "This is for testing. if you see this, i forgot to remove it.");

        this.mconf.add(new ModuleConfig.ConfigKey("mode", "y"));
        this.mconf.add(new ModuleConfig.ConfigKey("strength", "0.05"));
    }

    @Override
    public void onExecute() {
        double strength = Double.parseDouble(this.mconf.getByName("strength").value);
        assert MinecraftClient.getInstance().player != null;
        switch (this.mconf.getByName("mode").value) {
            case "y":

                MinecraftClient.getInstance().player.addVelocity(0, strength, 0);
                break;
            case "-y":
                MinecraftClient.getInstance().player.addVelocity(0, -strength, 0);
                break;
        }
        super.onExecute();
    }
}