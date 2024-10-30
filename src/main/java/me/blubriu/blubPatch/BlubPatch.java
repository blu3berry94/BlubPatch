package me.blubriu.blubPatch;

import me.blubriu.blubPatch.cmds.BlubPatchCommand;
import me.blubriu.blubPatch.cmds.DisableMLSCheck;
import me.blubriu.blubPatch.cmds.ReloadCommand;
import me.blubriu.blubPatch.errors.ArrowVelocity;
import me.blubriu.blubPatch.config.ConfigManager;
import me.blubriu.blubPatch.errors.MythicLibShulker;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class BlubPatch extends JavaPlugin {

    private ConfigManager configManager;
    private ArrowVelocity arrowVelocity;
    private MythicLibShulker mythicLibShulker;

    @Override
    public void onEnable() {
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage("§b");
        console.sendMessage("§b  ____  _       _     _____      _       _     ");
        console.sendMessage("§b |  _ \\| |     | |   |  __ \\    | |     | |    ");
        console.sendMessage("§b | |_) | |_   _| |__ | |__) |_ _| |_ ___| |__  ");
        console.sendMessage("§b |  _ <| | | | | '_ \\|  ___/ _` | __/ __| '_ \\ ");
        console.sendMessage("§b | |_) | | |_| | |_) | |  | (_| | || (__| | | |");
        console.sendMessage("§b |____/|_|\\__,_|_.__/|_|   \\__,_|\\__\\___|_| |_|");
        console.sendMessage("§b by §3Blub §9(_blueblub)");
        console.sendMessage("§b");
        mythicLibShulker = new MythicLibShulker(this);
        configManager = new ConfigManager(this);
        arrowVelocity = new ArrowVelocity(configManager);
        arrowVelocity.startCleanupTask();
        this.getCommand("blubpatch").setExecutor(new BlubPatchCommand(this));
        getLogger().info("Enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Unloaded!");
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public MythicLibShulker getMythicLibShulker() {
        return mythicLibShulker;
    }

    public ArrowVelocity getArrowVelocity() {
        return arrowVelocity;
    }
}