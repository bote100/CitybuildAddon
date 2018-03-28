package net.bote.citybuild.voteday;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bote.citybuild.api.Citybuild;
import net.bote.citybuild.main.Main;
import net.bote.citybuild.main.Var;

public class CMD_dayja implements CommandExecutor {
	
	private Main plugin;

	public CMD_dayja(Main main) {
		// TODO Auto-generated constructor stub
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		// TODO Auto-generated method stub
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(!VoteDayManager.list.contains(p.getName())) {
				if(!Citybuild.isVoteDayAvaible()) {
					p.sendMessage(Var.vdprefix+"§aDu hast für §2JA §agestimmt!");
					VoteDayManager.VOTEDAY_YES ++;
					VoteDayManager.list.add(p.getName());
				} else {
					p.sendMessage(Var.vdprefix+"§cZur Zeit ist kein VoteDay aktiv!");
				}
			} else {
				p.sendMessage(Var.vdprefix+"§cDu hast bereits abgestimmt!");
			}
		}
		return true;
	}

}
