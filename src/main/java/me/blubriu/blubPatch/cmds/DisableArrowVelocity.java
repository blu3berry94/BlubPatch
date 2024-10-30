package me.blubriu.blubPatch.cmds;

import me.blubriu.blubPatch.errors.ArrowVelocity;
import me.blubriu.blubPatch.BlubPatch;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DisableArrowVelocity implements CommandExecutor {
    private final BlubPatch plugin;

    public DisableArrowVelocity(BlubPatch plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("blubpatch.togglearrowvelocity")) {
            sender.sendMessage("§fLệnh này không tồn tại. Hãy kiểm tra lại đúng lệnh chưa nhé!");
            return true;
        }

        // check
        boolean currentStatus = plugin.getArrowVelocity().isEnabled();
        plugin.getArrowVelocity().setEnabled(!currentStatus); // change status

        String message = currentStatus
                ? "§8[§9BlubPatch§8] §aEnabled ArrowVelocity"
                : "§8[§9BlubPatch§8] §cDisabled ArrowVelocity";

        sender.sendMessage(message);
        return true;
    }
}