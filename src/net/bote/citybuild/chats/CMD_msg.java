package net.bote.citybuild.chats;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bote.citybuild.chat.ChatListener;
import net.bote.citybuild.main.Main;
import net.bote.citybuild.main.Var;

public class CMD_msg implements CommandExecutor {
	
	private static String prefix = "§cMSG §7| ";
	
	private Main plugin;

	public CMD_msg(Main main) {
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p =(Player) sender;
			if(args.length == 0 || args.length == 1) {
				sendHelpMSG(p);
			} else if(args.length >= 2) {
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null) {
					String msg = "";
					for(int i = 1; i < args.length; i++) {
						msg = msg + args[i] + " ";
					}
					if(!(p.getName() == target.getName())) {
						p.sendMessage(prefix+"§7[Du -> " + target.getName() + "] §e" + msg);
							if(!ChatListener.togglemsg.contains(target.getUniqueId())) {
								target.sendMessage(prefix+"§7[" + p.getName() + " -> Du] §e"+ msg);
								target.playSound(target.getLocation(), Sound.NOTE_BASS_DRUM, 3, 3);
								Main.lastSender.put(target.getUniqueId(), p.getUniqueId());
								Main.lastSender.put(p.getUniqueId(), target.getUniqueId());
							} else {
								p.sendMessage(Var.cb+"§cDieser Spieler erhält zur Zeit keine Nachrichten!");
							}
							
					} else {
						p.sendMessage(Var.cb+"§cDu kannst nicht mit dir selber schreiben!");
					}
				} else {
					p.sendMessage(Var.cb+"§cDieser Spieler ist offline!");
				}
			}
		}
		return true;
	}
	
	private void sendHelpMSG(Player p) {
		
		p.sendMessage(Var.cb+"§cNutze: §e/msg <Spielername> <Nachricht>");
		
	}

}
