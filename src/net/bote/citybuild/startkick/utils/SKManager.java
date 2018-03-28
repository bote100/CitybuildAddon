package net.bote.citybuild.startkick.utils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import net.bote.citybuild.main.Main;

public class SKManager implements Listener {
	private Main plugin;

	public SKManager(Main main) {
		// TODO Auto-generated constructor stub
		this.plugin = main;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onConnect(PlayerLoginEvent e) {
		if(Data.banneduuid.contains(e.getPlayer().getUniqueId())) {
			e.disallow(Result.KICK_WHITELIST, "§bDu wurdest für 5 Minuten aus Citybuild ausgeschlossen!");
		} else {
			e.allow();
		}
	}

}
