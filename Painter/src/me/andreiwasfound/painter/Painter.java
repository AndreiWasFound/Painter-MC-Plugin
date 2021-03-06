package me.andreiwasfound.painter;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Painter extends JavaPlugin {
	
	private List<Player> painters = new ArrayList<Player>();
	
	@Override
	public void onEnable() {
		this.getCommand("paint").setExecutor(new PaintCommand(this));
		this.getServer().getPluginManager().registerEvents(new PlayerInteract(this), this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public void addPainter(Player player) {
		painters.add(player);
	}
	
	public void removePainter(Player player) {
		painters.remove(player);
	}
	
	public List<Player> getPainters() {
		return painters;
	}
	
	public boolean hasPainters() {
		if (painters.isEmpty())
			return false;
		return true;
	}

}
