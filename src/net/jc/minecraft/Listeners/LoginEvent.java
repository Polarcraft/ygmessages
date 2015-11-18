package net.jc.minecraft.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import net.jc.minecraft.Main;

public class LoginEvent implements Listener {

	private Main plugin;
	  
	public LoginEvent(Main plugin) {
		this.plugin = plugin;
	}
	
    @SuppressWarnings("static-access")
	@EventHandler(priority = EventPriority.MONITOR)
    public void loginEvent(PlayerLoginEvent event)
    {
    	PlayerLoginEvent.Result result = event.getResult();
        Player p = event.getPlayer();
        if (event.getResult().equals(result.KICK_WHITELIST))
        {
            String WhitelistEvent = ChatColor.translateAlternateColorCodes('&', (String)plugin.getConfig().getString("kick-whitelist-message").replaceAll("%PLAYER%", p.getName().toString()));
            event.setKickMessage(WhitelistEvent);
        }
        
        if (event.getResult().equals(org.bukkit.event.player.PlayerLoginEvent.Result.KICK_FULL))
        {
            String FullEvent = ChatColor.translateAlternateColorCodes('&', (String)plugin.getConfig().getString("kick-full-message").replaceAll("%PLAYER%", p.getName().toString()));
            event.setKickMessage(FullEvent);
        }
    }
}
