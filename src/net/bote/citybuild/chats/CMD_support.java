package net.bote.citybuild.chats;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bote.citybuild.api.ChatSystem;
import net.bote.citybuild.chat.ChatListener;
import net.bote.citybuild.chat.ChatType;
import net.bote.citybuild.main.Main;
import net.bote.citybuild.main.Var;

public class CMD_support implements CommandExecutor {
	
	private Main plugin;
	
	private static ArrayList<UUID> wrote = new ArrayList<UUID>();

	public CMD_support(Main main) {
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(args.length > 0) {
				if(!p.hasPermission("citybuild.chat.support")) {
					if(!wrote.contains(p.getUniqueId())) {
						String msg = "";
						for(int i = 0; i < args.length; i++) {
							msg = msg + args[i] + " ";
						}
						ChatSystem.sendServerMessage(ChatType.SUPPORT, msg, p.getName());
						p.sendMessage("§9Citybuild §7| §aDu hast deine Nachricht erfolgreich an den Support geschickt!");
						int i = 0;
						for(Player all : Bukkit.getOnlinePlayers()) {
							if(all.hasPermission("citybuild.chat.support")) {
								if(!ChatListener.togglesup.contains(all.getUniqueId())) {
									i = i + 1;
								}
							}
						}
						p.sendMessage("§9Citybuild §7| §aEs sind zur Zeit §d" + i + " §aTeamler online, die dir helfen können.");
						i = 0;
						
						wrote.add(p.getUniqueId());
						Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
							
							@Override
							public void run() {
								
								wrote.remove(p.getUniqueId());
								
							}
						}, 20*60*1);
						
					} else {
						p.sendMessage(Var.cb+"§7Bitte warte einen Moment, bis du den §9Support §7erneut anschreibst!");
					}
				} else {
					p.sendMessage(Var.cb+"§cDu kannst keine Nachrichten an den Support senden!");
				}
			} else {
				p.sendMessage(Var.cb+"§7Nutze: §e/support <Deine Nachricht>");
			}
		}
		return true;
	}

}
