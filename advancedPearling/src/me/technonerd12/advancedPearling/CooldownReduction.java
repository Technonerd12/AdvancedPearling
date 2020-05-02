package me.technonerd12.advancedPearling;

import java.util.HashMap;
import java.util.UUID;
import java.util.function.BiConsumer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CooldownReduction implements Runnable {

	private static final BiConsumer<? super UUID, ? super Integer> UUID = null;
	private final Main plugin;

	public CooldownReduction(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public void run() {
		
		for (Player p : Bukkit.getOnlinePlayers()) {
			UUID uuid = p.getUniqueId();
			if (plugin.cooldowns.get(uuid) > 0) {
				plugin.cooldowns.put(uuid, plugin.cooldowns.get(uuid) - 0.1d);
			}
			else {
				return;
			}
		}
		
	}

}
