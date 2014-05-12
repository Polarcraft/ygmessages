package net.jc.minecraft.Listeners;

import net.jc.minecraft.Main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

public class KickEvent implements Listener {

	  private Main plugin;
	  
	  public KickEvent(Main plugin) {
	    this.plugin = plugin;
	  }
	
	  @EventHandler(priority = EventPriority.MONITOR)
	  public void kickEvent(PlayerKickEvent e){
		  Player p = e.getPlayer();
		  if(e.getLeaveMessage().contains("Server closed")){
			  String serverclosedEvent = ChatColor.translateAlternateColorCodes('&', (String)plugin.getConfig().getString("server-closed-message").replaceAll("%PLAYER%", p.getName().toString()));
		      e.setLeaveMessage(serverclosedEvent);
		  }
	  }
}
