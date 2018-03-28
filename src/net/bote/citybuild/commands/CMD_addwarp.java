package net.bote.citybuild.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bote.citybuild.main.Main;
import net.bote.citybuild.main.Var;

public class CMD_addwarp implements CommandExecutor {
	
	private Main plugin;
	
	public int anzahl = 0;

	public CMD_addwarp(Main main) {
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(p.hasPermission("citybuild.warp.addwarp")) {
				if(args.length == 2) {
					Player target = Bukkit.getPlayer(args[0]);
					anzahl = 0;
					try {
						anzahl = Integer.parseInt(args[1]);
					} catch (NumberFormatException e) {
						p.sendMessage(Main.getWarpManager().wprefix+"§cBitte gebe eine gültige Zahl an!");
						return true;
					}
					if(target != null) {
						Main.getWarpManager().setCounts(target.getUniqueId().toString(), Main.getWarpManager().getCounts(target.getUniqueId().toString()) + 1);
						p.sendMessage(Var.cb+"§aDu hast " + target.getName() + " erfolgreich" + anzahl +" Warp(s) hinzugefügt!");
						target.sendMessage(Var.cb+"§7Du hast" + anzahl + " §eSpawn(s) §7dazu bekommen!");
					} else {
						OfflinePlayer off = Bukkit.getOfflinePlayer(args[0]);
						if(off.isOnline()) {
							Main.getWarpManager().setCounts(off.getUniqueId().toString(), Main.getWarpManager().getCounts(off.getUniqueId().toString()) + 1);
							p.sendMessage(Var.cb+"§aDu hast " + p.getName() + " erfolgreich einen Warp hinzugefügt!");
						} else {
							if(off.hasPlayedBefore()) {
								Main.getWarpManager().setCounts(off.getUniqueId().toString(), Main.getWarpManager().getCounts(off.getUniqueId().toString()) + 1);
								p.sendMessage(Var.cb+"§aDu hast " + off.getName() + " erfolgreich einen Warp hinzugefügt!");
							} else {
								p.sendMessage(Var.cb+"§cDieser Spieler war noch nie online!");
							}
						}
					}
				} else {
					p.sendMessage("§7Nutze: §e/addwarp <Name> <Anzahl>");
				}
			}
		} else {
			if(args.length == 2) {
				Player target = Bukkit.getPlayer(args[0]);
				anzahl = 0;
				try {
					anzahl = Integer.parseInt(args[1]);
				} catch (NumberFormatException e) {
					System.out.println("Bitte gebe eine gültige Zahl an!");
					return true;
				}
				if(target != null) {
					Main.getWarpManager().setCounts(target.getUniqueId().toString(), Main.getWarpManager().getCounts(target.getUniqueId().toString()) + 1);
					System.out.println("Du hast " + target.getName() + " erfolgreich Warp(s) hinzugefügt!");
					target.sendMessage("Du hast" + anzahl + " §eSpawn(s) §7dazu bekommen!");
				} else {
					OfflinePlayer off = Bukkit.getOfflinePlayer(args[0]);
					if(off.isOnline()) {
						Main.getWarpManager().setCounts(off.getUniqueId().toString(), Main.getWarpManager().getCounts(off.getUniqueId().toString()) + 1);
						System.out.println("Du hast " + off.getName() + " erfolgreich Warp(s) hinzugefügt!");
					} else {
						if(off.hasPlayedBefore()) {
							Main.getWarpManager().setCounts(off.getUniqueId().toString(), Main.getWarpManager().getCounts(off.getUniqueId().toString()) + 1);
							System.out.println("Du hast " + off.getName() + " erfolgreich Warp(s) hinzugefügt!");
						} else {
							System.out.println("Dieser Spieler war noch nie online!");
						}
					}
				}
			}
		}
		
		return true;
	}

}
