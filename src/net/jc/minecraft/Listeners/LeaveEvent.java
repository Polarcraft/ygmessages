package net.jc.minecraft.Listeners;

import net.jc.minecraft.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {

	  private Main plugin;
	  
	  public LeaveEvent(Main plugin) {
	    this.plugin = plugin;
	  }
	
	@EventHandler
	public void leaveEvent(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage("");
		String LeaveEvent = ChatColor.translateAlternateColorCodes('&', (String)plugin.getConfig().getString("leave-message").replaceAll("%PLAYER%", p.getName().toString()));
		Bukkit.broadcastMessage(LeaveEvent);
	}
}
