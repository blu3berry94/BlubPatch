package me.blubriu.blubPatch.errors;

import me.blubriu.blubPatch.config.ConfigManager;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class ArrowVelocity {
    private final ConfigManager configManager;
    private boolean enabled = true;

    public ArrowVelocity(ConfigManager configManager) {
        this.configManager = configManager;
    }

    public void startCleanupTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!enabled) return;

                List<String> worldNames = configManager.getWorldNames();
                for (String worldName : worldNames) {
                    if (configManager.getPlugin().getServer().getWorld(worldName) != null) {
                        for (Entity entity : configManager.getPlugin().getServer().getWorld(worldName).getEntities()) {
                            if (entity instanceof Arrow) {
                                Arrow arrow = (Arrow) entity;
                                if (Double.isNaN(arrow.getVelocity().getX()) ||
                                        Double.isNaN(arrow.getVelocity().getY()) ||
                                        Double.isNaN(arrow.getVelocity().getZ())) {
                                    arrow.remove();
                                }
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(configManager.getPlugin(), 0, 20);
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }
}