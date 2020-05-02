package me.technonerd12.advancedPearling.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.technonerd12.advancedPearling.Main;

public class PearlConfigCommand implements CommandExecutor{
	private final Main plugin;

	public PearlConfigCommand(Main plugin) {
		this.plugin = plugin; // Store the plugin in situations where you need it.
	}
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//TODO Add methods when the command is executed.
		
		return false;
	}
	
}
