package me.technonerd12.advancedPearling.listeners;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.material.Gate;
import org.bukkit.util.Vector;

import me.technonerd12.advancedPearling.Main;

public class ProjectileListener implements Listener {
	private final Main plugin;

	public ProjectileListener(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPearlLand(ProjectileHitEvent e) {
		if (e.getEntity() instanceof EnderPearl) {
			if (e.getEntity().getShooter() instanceof Player) {
				Player p = (Player) e.getEntity().getShooter();
				EnderPearl pearl = (EnderPearl) e.getEntity();
				Location l = pearl.getLocation();
				Vector v = pearl.getVelocity();
				Location l2 = new Location(l.getWorld(), l.getX() + v.getX(), l.getY(), l.getZ() + v.getZ());

				// SLABS AND STAIRS

				if (l.getBlock().getType().name().contains("SLAB") || l.getBlock().getType().name().contains("STAIR")) {
					//p.sendMessage("TALI PEARL l");
					pearl.teleport(new Location(l.getWorld(), l.getBlockX() + 0.5, l.getBlockY(), l.getBlockZ() + 0.5));

				} else if (l2.getBlock().getType().name().contains("SLAB")
						|| l2.getBlock().getType().name().contains("STAIR")) {
					//p.sendMessage("TALI PEARL l2");
					pearl.teleport(
							new Location(l2.getWorld(), l2.getBlockX() + 0.5, l2.getBlockY(), l2.getBlockZ() + 0.5));
					
				}


			}

			else {
				return;
			}

		}

	}
}
