package me.andreiwasfound.painter;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PaintCommand implements CommandExecutor {
	
	private Painter plugin;
	public PaintCommand(Painter plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			// console
			sender.sendMessage("Only players can run this command!");
			return true;
		}
		Player player = (Player) sender;
		if (plugin.hasPainters()) {
			if (plugin.getPainters().contains(player)) {
				// remove the player
				plugin.removePainter(player);
				player.sendMessage(ChatColor.RED + "You can no longer paint!");
				return true;
			}
		}
		// add painter
		plugin.addPainter(player);
		player.sendMessage(ChatColor.GREEN + "You can now paint!");
		return true;
	}

}
