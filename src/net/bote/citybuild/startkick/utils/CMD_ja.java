package net.bote.citybuild.startkick.utils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bote.citybuild.api.Citybuild;
import net.bote.citybuild.main.Main;

public class CMD_ja implements CommandExecutor {

	private Main plugin;
	
	public CMD_ja(Main main) {
		// TODO Auto-generated constructor stub
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(!Citybuild.isStartkickAvaible()) {
				if(!Data.startkick_vote.contains(p.getName())) {
					Main.getData().yesvotes ++;
					Data.startkick_vote.add(p.getName());
					p.sendMessage(Main.StartKickPrefix+"§aDu hast für §2JA §agestimmt!");
				} else {
					p.sendMessage(Main.StartKickPrefix+"§cDu hast bereits gevotet!");
				}
			} else {
				p.sendMessage(Main.StartKickPrefix+"§cZur Zeit läuft leider kein StartKick!");
			}
		}
		return true;
	}

}
