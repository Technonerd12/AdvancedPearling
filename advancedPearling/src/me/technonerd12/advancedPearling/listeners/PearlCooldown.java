package me.technonerd12.advancedPearling.listeners;

import java.text.DecimalFormat;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import me.technonerd12.advancedPearling.Main;

public class PearlCooldown implements Listener {
	private final Main plugin;

	public PearlCooldown(Main plugin) {
		this.plugin = plugin;
	}

	public Double getValue(UUID key) {
		Double val = (Double) plugin.cooldowns.get(key);
		return val;
	}

	@EventHandler
	public void onPearlThrown(ProjectileLaunchEvent e) {
		if (e.getEntity() instanceof EnderPearl) {
			if (e.getEntity().getShooter() instanceof Player) {
				Player p = (Player) e.getEntity().getShooter();
				UUID uuid = p.getUniqueId();

				int pearls = p.getInventory().getItemInHand().getAmount();

				double cd = getValue(uuid);

				if (cd > 0.0d) {
					DecimalFormat numberFormat = new DecimalFormat("#.0");
					p.sendMessage(
							ChatColor.DARK_RED + "Pearl on cooldown for: " + numberFormat.format(cd) + " more seconds");
					e.setCancelled(true);
					p.getInventory().getItemInHand().setAmount(pearls + 1);
					return;
				} else {
					plugin.cooldowns.put((uuid), 16.0d);

				}
			}
		}

	}
}
