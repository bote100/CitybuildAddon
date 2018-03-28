package net.bote.citybuild.addons.handeln;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.bote.citybuild.main.Main;

public class CMD_handelnaccept implements CommandExecutor {

	private Main plugin;
	
	private static String prefix = "§7[§bHandeln§7] ";
	
	public CMD_handelnaccept(Main main) {
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(args.length == 1) {
				Player anfrage = Bukkit.getPlayer(args[0]);
				if(!Main.handelt.contains(anfrage)) {
					if(Main.cooldown.contains(anfrage)) { // Anfrage: handel cmd => p  &&  p => target
						Main.handelt.add(anfrage);
						Main.handelt.add(p);
						
						createInv(p, anfrage);
						p.playSound(p.getLocation(), Sound.CHEST_OPEN, 3, 3);
						anfrage.playSound(anfrage.getLocation(), Sound.CHEST_OPEN, 3, 3);
					} else {
						p.sendMessage(prefix+"§cDie Anfrage von " + anfrage.getName() + " ist aufgelaufen!");
					}
				} else {
					p.sendMessage(prefix+"§cDieser Spieler handelt bereits mit Jemanden!");
				}
			}
		}
		return true;
	}
	
	public void createInv(Player p, Player target) {
		Inventory inv = Bukkit.createInventory(null, 27, "§aHandeln");
		
		ItemStack i = new ItemStack(Material.STAINED_GLASS, 1, (short) 5);
		ItemMeta m = i.getItemMeta();
		m.setDisplayName("§7Status: §aAktiv");
		ArrayList<String> lores = new ArrayList<String>();
		lores.add("§aDein Patner handelt mit dir.");
		m.setLore(lores);
		i.setItemMeta(m);
		
		inv.setItem(18, i);
		inv.setItem(19, createItem());
		inv.setItem(20, createItem());
		inv.setItem(21, createItem());
		
		ItemStack item = new ItemStack(Material.SIGN);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§eInfo:");
		ArrayList<String> lorez = new ArrayList<String>();
		lorez.add("§e- Von allen Items, die durch Handeln verschwinden");
		lorez.add("§ewird keine Haftung übernommen.");
;		lorez.add("§e- §4Entnehme alle Items, bevor du das Inventar schließt.");
		meta.setLore(lorez);
		item.setItemMeta(meta);
		
		inv.setItem(26, item);
		inv.setItem(23, createItem());
		inv.setItem(24, createItem());
		inv.setItem(25, createItem());
		inv.setItem(22, createItem());
		p.openInventory(inv);
		target.openInventory(inv);
	}
	
	public static ItemStack createItem() {
		ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		ItemMeta m = i.getItemMeta();
		m.setDisplayName("§bHowTo:");
		ArrayList<String> lores = new ArrayList<String>();
		lores.add("§71. Lege ein Item ins Handelsmenü.");
		lores.add("§72. Der Spieler kann es sich Dieses dann nehmen.");
		m.setLore(lores);
		i.setItemMeta(m);
		return i;
	}
}
