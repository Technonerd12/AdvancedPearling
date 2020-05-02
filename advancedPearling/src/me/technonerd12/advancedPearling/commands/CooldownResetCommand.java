package me.technonerd12.advancedPearling.commands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.technonerd12.advancedPearling.Main;

public class CooldownResetCommand implements CommandExecutor {
	private final Main plugin;

	public CooldownResetCommand(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("advancedPearling.resetCooldown")) {
				if (args[0] == null || args[0] == "") {
					UUID uuid = p.getUniqueId();
					if (plugin.cooldowns.get(uuid) > 0.0) {
						plugin.cooldowns.put(uuid, 0.0);
						p.sendMessage(ChatColor.DARK_RED + "Your pearl cooldown has been reset!");
					}
				}
				else if (Bukkit.getPlayer(args[0]).isOnline()) {
					Player target = Bukkit.getPlayer(args[0]);
					UUID uuid = target.getUniqueId();
					if (plugin.cooldowns.get(uuid) > 0.0) {
						plugin.cooldowns.put(uuid, 0.0);
						p.sendMessage(ChatColor.DARK_RED + target.getDisplayName()+"'s pearl cooldown has been reset!");
					}
				}
				else {
					p.sendMessage(ChatColor.DARK_RED + "That player is not online.");
				}
				
			}
		}

		return false;
	}

}
