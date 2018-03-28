package net.bote.citybuild.addons;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import net.bote.citybuild.api.Skull;
import net.bote.citybuild.drops.Drops;
import net.bote.citybuild.main.Main;

public class CMD_pe implements CommandExecutor {

	private Main plugin;
	
	public CMD_pe(Main main) {
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			Inventory inv = Bukkit.createInventory(null, 9, "§b§lPlot-Settings");
			inv.setItem(2, Drops.createItem(Material.SIGN, "§6Infos über das Plot"));
			inv.setItem(4, Skull.createSkull(p.getName(), "§cFreunde anzeigen", 1));
			inv.setItem(6, Drops.createItem(Material.WOOD_DOOR, "§bTeleportier dich zu deinem Home"));
			p.openInventory(inv);
			p.playSound(p.getLocation(), Sound.CHEST_OPEN, 3, 3);
			
		} else {
			System.out.println("Du musst ein Spieler sein!");
		}
		return true;
	}

}
