package net.bote.citybuild.crates;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.bote.citybuild.main.Main;
import net.bote.citybuild.main.Var;

public class JoinListener implements Listener {
	
	private Main plugin;

	public JoinListener(Main main) {
		// TODO Auto-generated constructor stub
		this.plugin = main;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if(CMD_givecrates.crates.containsKey(e.getPlayer().getUniqueId())) {
			CrateType type = CMD_givecrates.crates.get(e.getPlayer().getUniqueId());
			e.getPlayer().getInventory().addItem(Crates.giveCrate(type, CMD_givecrates.menge.get(e.getPlayer().getUniqueId())));
			e.getPlayer().sendMessage(Var.cb+"§aDu hast Kisten erhalten");
			CMD_givecrates.menge.remove(e.getPlayer().getUniqueId());
			CMD_givecrates.crates.remove(e.getPlayer().getUniqueId());
		}
	}

}
