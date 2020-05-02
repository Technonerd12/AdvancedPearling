package me.technonerd12.advancedPearling.listeners;

import java.util.UUID;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.technonerd12.advancedPearling.Main;

public class JoinListener implements Listener {
	private final Main plugin;

	public JoinListener(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		if (plugin.cooldowns.get(e.getPlayer().getUniqueId()) == null) {
			plugin.cooldowns.put(e.getPlayer().getUniqueId(), 0.0);
		}

	}

}
