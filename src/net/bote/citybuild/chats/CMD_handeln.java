package net.bote.citybuild.chats;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bote.citybuild.api.ChatSystem;
import net.bote.citybuild.chat.ChatType;
import net.bote.citybuild.main.Main;

public class CMD_handeln implements CommandExecutor {
	
	private Main plugin;

	public CMD_handeln(Main main) {
		// TODO Auto-generated constructor stub
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(args.length > 0) {
				String msg = "";
				for(int i = 0; i < args.length; i++) {
					msg = msg + args[i] + " ";
				}
				ChatSystem.sendServerMessage(ChatType.HANDEL, msg, p.getName());
			} else {
				p.sendMessage("§7Nutze: §e/handeln <Deine Nachricht>");
			}
		}
		return true;
	}

}
