package me.blubriu.blubPatch.cmds;

import me.blubriu.blubPatch.BlubPatch;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ReloadCommand implements CommandExecutor {

    private final BlubPatch plugin;

    public ReloadCommand(BlubPatch plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("blubpatch.reload")) {
            plugin.getConfigManager().reloadConfig();
            sender.sendMessage("§8[§9BlubPatch§8] §aReloaded Config!");
        } else {
            sender.sendMessage("§fLệnh này không tồn tại. Hãy kiểm tra lại đúng lệnh chưa nhé!");
        }
        return true;
    }
}