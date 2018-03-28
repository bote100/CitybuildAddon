package net.bote.citybuild.crates;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bote.citybuild.main.Main;

public class CMD_crates implements CommandExecutor {
	
	private Main plugin;
	
	

	public CMD_crates(Main main) {
		// TODO Auto-generated constructor stub
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		// TODO Auto-generated method stub
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(p.hasPermission("citybuild.crates")) {
				
				Crates.openAdminInv(p);
				
			} else {
				p.sendMessage(Crates.prefix+"§cKein Recht!");
			}
		}
		return true;
	}

}
