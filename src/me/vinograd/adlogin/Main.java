package me.vinograd.adlogin;

import me.vinograd.adlogin.core.*;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {
    private FileConfiguration data;
    public void onEnable(){
        Logger.getLogger("Admin login start!");
        adminlogin take = new adminlogin();
        Bukkit.getPluginManager().registerEvents(new adminlogin(),this);
        getCommand("alogin13").setExecutor(new Command(this));
        getCommand("aadd14").setExecutor(new Writing(this));
        getCommand("admend").setExecutor(new end(this));
        getCommand("anlogin15").setExecutor(new unlogin(this));
    }
}
