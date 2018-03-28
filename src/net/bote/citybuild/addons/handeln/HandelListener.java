package net.bote.citybuild.addons.handeln;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.bote.citybuild.main.Main;

public class HandelListener implements Listener {
	
	private Main plugin;

	public HandelListener(Main main) {
		this.plugin = main;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		try {
			if(e.getInventory().getName().equalsIgnoreCase("§aHandeln")) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bHowTo:") ||
						e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Status: §aAktiv") ||
						e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Status: §cGeschlossen") ||
						e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eInfo:")) {
					
					e.setCancelled(true);
				}
			}
		} catch (NullPointerException ignored) {
			
		}
	}
	
	@EventHandler
	public void onClose(InventoryCloseEvent e) {
		try {
			if(e.getInventory().getName().equalsIgnoreCase("§aHandeln")) {
				ItemStack i = new ItemStack(Material.STAINED_GLASS, 1, (short) 14);
				ItemMeta m = i.getItemMeta();
				m.setDisplayName("§7Status: §cGeschlossen");
				ArrayList<String> lores = new ArrayList<String>();
				lores.add("§cDein Patner handelt nicht mehr.");
				m.setLore(lores);
				i.setItemMeta(m);
				Inventory inv = e.getInventory();
				inv.setItem(18, i);
				
				Main.handelt.remove(e.getPlayer());
			}
		} catch (NullPointerException ignored) {
			
		}
	}
}
