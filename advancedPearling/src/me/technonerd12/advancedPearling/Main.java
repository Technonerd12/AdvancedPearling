package me.technonerd12.advancedPearling;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.technonerd12.advancedPearling.commands.CooldownResetCommand;
import me.technonerd12.advancedPearling.listeners.JoinListener;
import me.technonerd12.advancedPearling.listeners.PearlCooldown;
import me.technonerd12.advancedPearling.listeners.PearlHitListener;
import me.technonerd12.advancedPearling.listeners.ProjectileListener;

public class Main extends JavaPlugin {
	
	public Map<UUID, Double> cooldowns = new HashMap<UUID, Double>();
	

	
	public void registerListeners() {
        getServer().getPluginManager().registerEvents(new ProjectileListener(this), this);		
        getServer().getPluginManager().registerEvents(new PearlCooldown(this), this);
		getServer().getPluginManager().registerEvents(new JoinListener(this), this);
		getServer().getPluginManager().registerEvents(new PearlHitListener(this), this);
	}
	public void registerCommands () {
		this.getCommand("resetcooldown").setExecutor(new CooldownResetCommand(this));
	}
	
	
	
	public void onEnable() {
		registerCommands();
		registerListeners();
		Bukkit.getScheduler().runTaskTimer(this, new CooldownReduction(this), 0, 4);
	}
	
	public void onDisable() {
		
	}

}
