package net.bote.citybuild.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bote.citybuild.api.Citybuild;
import net.bote.citybuild.main.Main;
import net.bote.citybuild.main.Var;

public class CMD_near implements CommandExecutor {
	
	private Main plugin;
	
	public CMD_near(Main main) {
		// TODO Auto-generated constructor stub
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(p.hasPermission("citybuild.near")) {
				if(args.length == 0) {
					try {
						Player target = Citybuild.getNearestPlayer(p);
						
						int bl = (int) p.getLocation().distance(Citybuild.getNearestPlayer(p).getLocation());
						p.sendMessage("§7[§2Tracker§7] " + target.getName() + " ist §e" + bl + "m§7 entfernt!");
					} catch (NullPointerException ignored) {
						
						p.sendMessage("§7[§2Tracker§7] §cEs wurde kein Spieler gefunden!");
					}
					
				} else {
					p.sendMessage("§9Citybuild §7| §cNutze: /near");
				}
			} else {
				p.sendMessage(Var.cb+"§cKein Recht!");
			}
		}
		return true;
	}

}
