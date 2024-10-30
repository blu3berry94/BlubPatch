package me.blubriu.blubPatch.errors;

import me.blubriu.blubPatch.BlubPatch;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class MythicLibShulker implements Listener {
    private final BlubPatch plugin;
    private boolean checkEnabled = true;

    public MythicLibShulker(BlubPatch plugin) {
        this.plugin = plugin;
    }

    public boolean isCheckEnabled() {
        return checkEnabled;
    }

    public void setCheckEnabled(boolean checkEnabled) {
        this.checkEnabled = checkEnabled;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        if (!checkEnabled) {
            return;
        }

        if (event.getPlayer().isOnline()) {
            // Online = allow
            return;
        }

        ItemStack item = event.getItemDrop().getItemStack();
        if (item != null && item.getType().equals(Material.SHULKER_BOX)) {
            // Check offline
            event.setCancelled(true);
        }
    }
}