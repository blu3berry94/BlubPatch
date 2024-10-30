package me.blubriu.blubPatch.cmds;

import me.blubriu.blubPatch.BlubPatch;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DisableMLSCheck implements CommandExecutor {
    private final BlubPatch plugin;

    public DisableMLSCheck(BlubPatch plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("blubpatch.disableshulkercheck")) {
            sender.sendMessage("§fLệnh này không tồn tại. Hãy kiểm tra lại đúng lệnh chưa nhé!");
            return true;
        }

        if (args.length == 0 || !args[0].equalsIgnoreCase("disableshulkercheck")) {
            return false; // return usage
        }

        // toggle check
        boolean currentStatus = plugin.getMythicLibShulker().isCheckEnabled();
        plugin.getMythicLibShulker().setCheckEnabled(!currentStatus);

        String message = currentStatus
                ? "§8[§9BlubPatch§8] §2[MLSC] §aShulker box drop check has been disabled."
                : "§8[§9BlubPatch§8] §4[MLSC] §cShulker box drop check has been enabled.";
        sender.sendMessage(message);
        return true;
    }
}