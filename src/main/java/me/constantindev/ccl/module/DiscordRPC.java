/*
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# Project: Cornos
# File: DiscordRPC
# Created by constantin at 08:47, Mär 02 2021
PLEASE READ THE COPYRIGHT NOTICE IN THE PROJECT ROOT, IF EXISTENT
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
*/
package me.constantindev.ccl.module;

import me.constantindev.ccl.etc.base.Module;
import me.constantindev.ccl.etc.ms.DiscordRPCThread;

public class DiscordRPC extends Module {
    DiscordRPCThread instance = null;

    public DiscordRPC() {
        super("DiscordRPC", "Displays a nice rich presence if you have the discord client on");
    }

    @Override
    public void onEnable() {
        instance = new DiscordRPCThread();
        super.onEnable();
    }

    @Override
    public void onExecute() {
        if (instance == null) onEnable();
        super.onExecute();
    }

    @Override
    public void onDisable() {
        if (instance != null) instance.shutdown();
        super.onDisable();
    }
}
