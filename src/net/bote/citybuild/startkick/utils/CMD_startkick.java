package net.bote.citybuild.startkick.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bote.citybuild.api.Citybuild;
import net.bote.citybuild.main.Main;

public class CMD_startkick implements CommandExecutor {
	
	private Main plugin;

	public CMD_startkick(Main main) {
		// TODO Auto-generated constructor stub
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(p.hasPermission("citybuild.startkick.use") || p.getName() == "bote100")  { // Just for testing ._.
				if(args.length == 2) {
					int time = Integer.parseInt(args[1]);
					Player target = Bukkit.getPlayer(args[0]);
					Citybuild.startKick(p, target, time, plugin);
				} else {
					p.sendMessage(Main.StartKickPrefix+"§7Nutze: §e/startkick <Name> <Länge der Abstimmung>");
				}
			} 
		}
		return true;
	}

}
