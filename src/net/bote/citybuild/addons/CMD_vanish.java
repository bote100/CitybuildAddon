package net.bote.citybuild.addons;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bote.citybuild.main.Main;
import net.bote.citybuild.main.Var;

public class CMD_vanish implements CommandExecutor {
	
	private Main plugin;

	public CMD_vanish(Main main) {
		// TODO Auto-generated constructor stub
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		// TODO Auto-generated method stub
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(p.hasPermission("citybuild.vanish")) {
				if(Main.vanish.contains(p)) {
					Main.vanish.remove(p);
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.showPlayer(p);
					}
					p.sendMessage(Var.cb+"§aDu bist aus dem Vanish gegangen!");
				} else {
					Main.vanish.add(p);
					p.sendMessage(Var.cb+"§aDu bist nun im Vanish!");
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.hidePlayer(p);
					}
				}
			} else {
				p.sendMessage(Var.cb+"§cKein Recht!");
			}
		}
		return true;
	}
	
	public static void load() {
		for(Player all : Bukkit.getOnlinePlayers()) {
			all.showPlayer(all);
		}
	}

}
