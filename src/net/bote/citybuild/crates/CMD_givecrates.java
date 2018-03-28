package net.bote.citybuild.crates;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bote.citybuild.main.Main;
import net.bote.citybuild.main.Var;

public class CMD_givecrates implements CommandExecutor {
	
	public CrateType type;
	
	public static HashMap<UUID, CrateType> crates = new HashMap<UUID, CrateType>();
	public static HashMap<UUID, Integer> menge = new HashMap<UUID, Integer>();
	
	private Main plugin;

	public CMD_givecrates(Main main) {
		// TODO Auto-generated constructor stub
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		// TODO Auto-generated method stub
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(p.hasPermission("citybuild.givecrates")) {
				if(args.length == 3) {
					Player target = Bukkit.getPlayer(args[0]);
					int amount;
					try {
						amount = Integer.parseInt(args[2]);
					} catch (NumberFormatException e) {
						p.sendMessage(Var.cb+"§7Nutze: §e/givecrates <Spieler> <Crate> <Anzahl>");
						return true;
					}
					if(args[1].equalsIgnoreCase("Spieler")) {
						type = CrateType.Player_Crate;
					} else if(args[1].equalsIgnoreCase("Legend")) {
						type = CrateType.Legend_Crate;
					} else if(args[1].equalsIgnoreCase("Ultra")) {
						type = CrateType.Ultra_Crate;
					} else if(args[1].equalsIgnoreCase("Champion")) {
						type = CrateType.Champion_Crate;
					} else {
						p.sendMessage(Var.cb+"§7Nutze: §e/givecrates <Spieler> <Crate> <Anzahl>");
						p.sendMessage("§6Crates: §7Spieler§6, §2Legend§6, §bUltra§6, §cChampion");
						return true;
					}
					if(target != null) {
						target.getInventory().addItem(Crates.giveCrate(type, amount));
						p.sendMessage(Var.cb+"§aDu hast " + args[0] + " Kisten gutgeschrieben");
					} else {
						OfflinePlayer off = Bukkit.getOfflinePlayer(args[0]);
						if(off.isOnline()) {
							target = (Player) off;
							target.getInventory().addItem(Crates.giveCrate(type, amount));
						} else {
							if(off.hasPlayedBefore()) {
								crates.put(off.getUniqueId(), type);
								menge.put(off.getUniqueId(), amount);
								p.sendMessage(Var.cb+"§aDu hast " + args[0] + " Kisten gutgeschrieben");
							} else {
								p.sendMessage(Var.cb+"§cDieser Spieler war noch §4nie §cauf dem Citybuild Server!");
							}
						}
					}
				} else {
					p.sendMessage(Var.cb+"§7Nutze: §e/givecrates <Spieler> <Crate> <Anzahl>");
				}
			}
		} else {
			if(args.length == 3) {
				Player target = Bukkit.getPlayer(args[0]);
				int amount;
				try {
					amount = Integer.parseInt(args[2]);
				} catch (NumberFormatException e) {
					System.out.println("Nutze: /givecrates <Spieler> <Crate> <Anzahl>");
					return true;
				}
				if(args[1].equalsIgnoreCase("Spieler")) {
					type = CrateType.Player_Crate;
				} else if(args[1].equalsIgnoreCase("Legend")) {
					type = CrateType.Legend_Crate;
				} else if(args[1].equalsIgnoreCase("Ultra")) {
					type = CrateType.Ultra_Crate;
				} else if(args[1].equalsIgnoreCase("Champion")) {
					type = CrateType.Champion_Crate;
				} else {
					System.out.println("Nutze: /givecrates <Spieler> <Crate> <Anzahl>");
					System.out.println("Crates: Spieler, Legend, Ultra, Champion");
					return true;
				}
				if(target != null) {
					target.getInventory().addItem(Crates.giveCrate(type, amount));
					System.out.println("Du hast " + args[0] + " Kisten gutgeschrieben");
				} else {
					OfflinePlayer off = Bukkit.getOfflinePlayer(args[0]);
					if(off.isOnline()) {
						target = (Player) off;
						target.getInventory().addItem(Crates.giveCrate(type, amount));
					} else {
						if(off.hasPlayedBefore()) {
							crates.put(off.getUniqueId(), type);
							menge.put(off.getUniqueId(), amount);
							System.out.println("Du hast " + args[0] + " Kisten gutgeschrieben");
						} else {
							System.out.println("Dieser Spieler war noch nie §cauf dem Citybuild Server!");
						}
					}
				}
			} else {
				System.out.println("Nutze: /givecrates <Spieler> <Crate> <Anzahl>");
			}
		}
		return true;
	}

}
