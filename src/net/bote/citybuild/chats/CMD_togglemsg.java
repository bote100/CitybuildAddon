package net.bote.citybuild.chats;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bote.citybuild.chat.ChatListener;
import net.bote.citybuild.main.Main;
import net.bote.citybuild.main.Var;

public class CMD_togglemsg implements CommandExecutor {
	
	private Main plugin;

	public CMD_togglemsg(Main main) {
		// TODO Auto-generated constructor stub
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		// TODO Auto-generated method stub
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(p.hasPermission("citybuild.chat.toggle.msg")) {
				if(!ChatListener.togglemsg.contains(p.getUniqueId())) {
					ChatListener.togglemsg.add(p.getUniqueId());
					p.sendMessage(Var.cb+"§cDu erhälst nun keine §cNachrichten §cmehr!");
				} else {
					ChatListener.togglemsg.remove(p.getUniqueId());
					p.sendMessage(Var.cb+"§aDu erhälst nun wieder §cNachrichten§a!");
				}
			} else {
				p.sendMessage(Var.cb+"§cKein Recht!");
			}
		}
		return true;
	}

}
