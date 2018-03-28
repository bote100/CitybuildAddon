package net.bote.citybuild.addons;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import net.bote.citybuild.main.Main;

public class PlotEdit implements Listener {
	
	private Main plugin;

	public PlotEdit(Main main) {
		this.plugin = main;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		Player p = (Player)e.getWhoClicked();
		
		if(e.getInventory().getName().equalsIgnoreCase("§b§lPlot-Settings")) {
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Infos über das Plot")) {
				p.performCommand("land infos");
				p.closeInventory();
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cFreunde anzeigen")) {
				p.performCommand("land friends");
				p.closeInventory();
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bTeleportier dich zu deinem Home")) {
				p.performCommand("home");
				p.closeInventory();
			}
		}
	}

}