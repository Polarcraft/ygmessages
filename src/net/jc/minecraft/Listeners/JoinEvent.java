package net.jc.minecraft.Listeners;

import net.jc.minecraft.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

	  private Main plugin;
	  
	  public JoinEvent(Main plugin) {
	    this.plugin = plugin;
	  }
	  
		@EventHandler
		public void joinEvent(PlayerJoinEvent e) {
			e.setJoinMessage("");
			Player p2 = e.getPlayer();
			if(e.getPlayer().hasPlayedBefore()) {
				String JoinEvent1 = ChatColor.translateAlternateColorCodes('&', (String)plugin.getConfig().getString("old-join-message").replaceAll("%PLAYER%", p2.getName().toString()));
				Bukkit.broadcastMessage(JoinEvent1);
			} else {
				String JoinEvent2 = ChatColor.translateAlternateColorCodes('&', (String)plugin.getConfig().getString("new-join-message").replaceAll("%PLAYER%", p2.getName().toString()));
				Bukkit.broadcastMessage(JoinEvent2);
			}
		}
}
