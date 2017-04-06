package me.kieranslayer.sm;

import me.kieranslayer.sm.commands.*;
import me.kieranslayer.sm.updater.Updater;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;
/**
 * Created by KieranSlayer on 25/03/2017.
 */
public class Main extends JavaPlugin
        implements Listener {

        
        
        
    public void onEnable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        Logger logger = Logger.getLogger("minecraft");
        this.registerCommands();
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        logger.info(pdfFile.getName() + "Has Been enabled + This Was Developer by KieranSlayer(V." + pdfFile.getVersion() + ")");
       
    }
    
    public void update() {
        if(Updater.getResource(38305, 1.3D)) {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Ther's a new update avaliable for PluginName");
        }

    }

    private void registerCommands(){
        this.getCommand("discord").setExecutor(new Discord(this));
        this.getCommand("serverip").setExecutor(new ServerIP(this));
        this.getCommand("website").setExecutor(new Website(this));
        this.getCommand("facebook").setExecutor(new Website(this));
        this.getCommand("twitter").setExecutor(new Twitter(this));
        this.getCommand("teamspeak").setExecutor(new TeamSpeak(this));
    }
    public void onDisabled() {
        PluginDescriptionFile pdfFile = this.getDescription();
        Logger logger = Logger.getLogger("");
        getConfig().options().copyDefaults(true);
        saveConfig();
        logger.info(pdfFile.getName() + "Has Been disabled + This Was Developer by KieranSlayer (V." + pdfFile.getVersion() + ")");
    }


}

