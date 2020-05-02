package me.technonerd12.advancedPearling.listeners;

import org.bukkit.Location;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.material.Gate;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import me.technonerd12.advancedPearling.Main;

public class PearlHitListener implements Listener {

	private final Main plugin;

	public PearlHitListener(Main plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@EventHandler(ignoreCancelled = true)
	public void onPearlThrown(ProjectileLaunchEvent e) {
		if (e.getEntity() instanceof EnderPearl) {
			if (e.getEntity().getShooter() instanceof Player) {
				Player p = (Player) e.getEntity().getShooter();
				EnderPearl pearl = (EnderPearl) e.getEntity();

				new BukkitRunnable() {

					@Override
					public void run() {
						if (!pearl.isDead()) {
							Location l = pearl.getLocation();
							Vector v = pearl.getVelocity();
							
							double vx = 0, vz = 0;
							
							
							if (v.getX() > 0 && v.getX() < 0.5) {vx = v.getX();}
							else if (v.getX() > 0.5){vx = 0.5;}							
							if (v.getX() < 0 && v.getX() > -0.5) {vx = v.getX();}
							else if (v.getX() < -0.5){vx = -0.5;}	
							
							if (v.getZ() > 0 && v.getZ() < 0.5) {vz = v.getZ();}
							else if (v.getZ() > 0.5){vz = 0.5;}							
							if (v.getZ() < 0 && v.getZ() > -0.5) {vz = v.getZ();}
							else if (v.getZ() < -0.5){vz = -0.5;}							
							
							
							
							Location l2 = new Location(l.getWorld(), l.getX() + v.getX(), l.getY(),
									l.getZ() + v.getZ());

							// FENCEGATES

							if (l2.getBlock().getType().name().contains("FENCE_GATE")) {
								if (((Gate) l2.getBlock().getState().getData()).isOpen()) {
									//p.sendMessage("2");
									pearl.teleport(new Location(l2.getWorld(), l2.getX() + vx, l2.getBlockY(),
											l2.getBlockZ() + vz));

								}

							}

						}
					}

				}.runTaskTimer(plugin, 0, 1);

			}
		}

	}

}
