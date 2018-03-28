package net.bote.citybuild.voteday;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bote.citybuild.api.Citybuild;
import net.bote.citybuild.main.Main;
import net.bote.citybuild.main.Var;

public class CMD_voteday implements CommandExecutor {
	
	private Main plugin;	

	public CMD_voteday(Main main) {
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		// TODO Auto-generated method stub
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(args.length == 2) {
				if(args[0].equalsIgnoreCase("Tag") || args[0].equalsIgnoreCase("Nacht")) {
					VoteDayState state = null;
					if(args[0].equalsIgnoreCase("Tag")) {
						state = VoteDayState.TAG;
					} else if(args[0].equalsIgnoreCase("Nacht")) {
						state = VoteDayState.NACHT;
					}
					int time;
					try {
						time = Integer.parseInt(args[1]);
						VoteDayManager.VOTEDAY_NO = 0;
						VoteDayManager.VOTEDAY_YES = 0;
						Citybuild.createVoteDay(p, time, state, plugin);
					} catch (NumberFormatException e) {
						p.sendMessage(Var.vdprefix+"§7Nutze: §e/voteday <Tag | Nacht> <Länge der Abstimmung>");
						time = 0;
					}
				}
			} else {
				p.sendMessage(Var.vdprefix+"§7Nutze: §e/voteday <Tag | Nacht> <Länge der Abstimmung>");
			}
		}
		return true;
	}

}
