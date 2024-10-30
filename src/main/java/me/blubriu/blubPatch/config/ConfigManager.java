package me.blubriu.blubPatch.config;

import me.blubriu.blubPatch.BlubPatch;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class ConfigManager {
    private final BlubPatch plugin;
    private FileConfiguration config;

    public ConfigManager(BlubPatch plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    public void loadConfig() {
        plugin.saveDefaultConfig();
        config = plugin.getConfig();
    }

    public void reloadConfig() {
        plugin.reloadConfig();
        loadConfig();
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public List<String> getWorldNames() {
        return config.getStringList("worlds");
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }
}