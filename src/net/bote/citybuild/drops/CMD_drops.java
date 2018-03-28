package net.bote.citybuild.drops;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bote.citybuild.main.Main;

public class CMD_drops implements CommandExecutor {
	
	private Main plugin;

	public CMD_drops(Main main) {
		// TODO Auto-generated constructor stub
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		// TODO Auto-generated method stub
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(p.hasPermission("citybuild.drops")) {
				Drops.openMenu(p);
				p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 3, 3);
			} else {
				p.sendMessage(Drops.prefix + "§cKein Recht!");
			}
		}
		return true;
	}

}
