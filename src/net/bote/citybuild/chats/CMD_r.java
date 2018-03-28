package net.bote.citybuild.chats;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bote.citybuild.chat.ChatListener;
import net.bote.citybuild.main.Main;
import net.bote.citybuild.main.Var;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Sound;

public class CMD_r implements CommandExecutor {
	
	private static String prefix = "§7[§cMSG§7] ";
	
	private Main plugin;

	public CMD_r(Main main) {
		// TODO Auto-generated constructor stub
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(Main.lastSender.containsKey(p.getUniqueId())) {
				Player target = Bukkit.getPlayer((UUID)Main.lastSender.get(p.getUniqueId()));
				if(target != null) {
					String msg = "";
					for(int i = 0; i < args.length; i++) {
						msg = msg + args[i] + " ";
					}
					
					if(!(p.getName() == target.getName())) {
						p.sendMessage(prefix+"§7[Du -> " + target.getName() + "] §e" + msg);
							if(!ChatListener.togglemsg.contains(target.getUniqueId())) {
								target.sendMessage(prefix+"§7[" + p.getName() + " -> Du] §e"+ msg);
								target.playSound(target.getLocation(), Sound.NOTE_BASS, 3, 3);
							} else {
								p.sendMessage(Var.cb+"§cDieser Spieler erhält zur Zeit keine Nachrichten!");
							}
					} else {
						p.sendMessage(Var.cb+"§cDu kannst nicht mit dir selber schreiben!");
					}
					
				} else {
					p.sendMessage(Var.cb+"§cDie Nachricht konnte nicht gesendet werden!");
				}
			} else {
				p.sendMessage(Var.cb+"§cEs wurde keine letzte Nachricht gefunden!");
			}
		}
		return true;
	}

}
