package me.constantindev.ccl.etc.helper;

import me.constantindev.ccl.Cornos;
import me.constantindev.ccl.etc.ms.KeyBind;
import me.constantindev.ccl.etc.reg.ModuleRegistry;

import java.util.HashMap;
import java.util.Map;

public class KeyBindManager {
    public static Map<String, KeyBind> binds = new HashMap<>();

    public static void init() {
        ModuleRegistry.getAll().forEach(module -> {
            if (!module.mconf.getByName("keybind").value.equals("-1.0")) {
                binds.put(module.name, new KeyBind((int) Double.parseDouble(module.mconf.getByName("keybind").value)));
            }
        });
    }

    public static void tick() {
        binds.forEach((s, keyBinding) -> {

            if (keyBinding.isPressed() && Cornos.minecraft.currentScreen == null)
                ModuleRegistry.getByName(s).isOn.toggle();
        });
    }

    public static void reload() {
        binds.clear();
        init();
    }
}
