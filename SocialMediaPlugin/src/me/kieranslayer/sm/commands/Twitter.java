package me.kieranslayer.sm.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.kieranslayer.sm.Main;

public class Twitter implements CommandExecutor {

	  private Main plugin;
	  
	  public Twitter(Main pl)
	  {
	    plugin = pl;
	  }
	  
	  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	  {
	    if ((label.equalsIgnoreCase("twitter")) && 
	      (!(sender instanceof Player))) {
	      sender.sendMessage("You Cant do That Command Console Bye");
	      return false;
	    }
	    
	    Player player = (Player)sender;
	    player.sendMessage(ChatColor.translateAlternateColorCodes ('&',plugin.getConfig().getString("Twitter")));
	    return true;
	  }
	}