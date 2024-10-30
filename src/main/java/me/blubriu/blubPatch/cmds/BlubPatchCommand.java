package me.blubriu.blubPatch.cmds;

import me.blubriu.blubPatch.BlubPatch;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BlubPatchCommand implements CommandExecutor {
    private final BlubPatch plugin;

    public BlubPatchCommand(BlubPatch plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§8[§9BlubPatch§8] §fmmb");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "disableshulkercheck":
                if (!sender.hasPermission("blubpatch.disableshulkercheck")) {
                    sender.sendMessage("§fLệnh này không tồn tại. Hãy kiểm tra lại đúng lệnh chưa nhé!");
                    return true;
                }
                new DisableMLSCheck(plugin).onCommand(sender, command, label, args);
                break;
            case "reload":
                if (!sender.hasPermission("blubpatch.reload")) {
                    sender.sendMessage("§fLệnh này không tồn tại. Hãy kiểm tra lại đúng lệnh chưa nhé!");
                    return true;
                }
                new ReloadCommand(plugin).onCommand(sender, command, label, args);
                break;
            case "togglearrowvelocity":
                if (!sender.hasPermission("blubpatch.togglearrowvelocity")) {
                    sender.sendMessage("§fLệnh này không tồn tại. Hãy kiểm tra lại đúng lệnh chưa nhé!");
                    return true;
                }
                new DisableArrowVelocity(plugin).onCommand(sender, command, label, args);
                break;
            default:
                sender.sendMessage("§fLệnh này không tồn tại. Hãy kiểm tra lại đúng lệnh chưa nhé!");
                break;
        }
        return true;
    }
}