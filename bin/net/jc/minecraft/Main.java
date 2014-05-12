package net.jc.minecraft;

import net.jc.minecraft.Listeners.KickEvent;
import net.jc.minecraft.Listeners.JoinEvent;
import net.jc.minecraft.Listeners.LeaveEvent;
import net.jc.minecraft.Listeners.LoginEvent;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public void onEnable() {
		getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
		getServer().getPluginManager().registerEvents(new LeaveEvent(this), this);
		getServer().getPluginManager().registerEvents(new LoginEvent(this), this);
		getServer().getPluginManager().registerEvents(new KickEvent(this), this);
    	getConfig().options().copyDefaults(true);
    	saveDefaultConfig();
	}
}
