package net.bote.citybuild.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.bote.citybuild.chat.ChatListener;
import net.bote.citybuild.chat.ChatType;

public class ChatSystem {
	
	public static void sendServerMessage(ChatType ct, String msg) {
		if(ct == ChatType.GLOBAL) {
			Bukkit.broadcastMessage("§7[§dG§7] " + msg);
		} else if(ct == ChatType.SUPPORT) {
			for(Player all : Bukkit.getOnlinePlayers()) {
				if(all.hasPermission("citybuild.chat.support")) {
					all.sendMessage("§7[§9§lSUP§r§7] " + msg);
				}
			}
		} else if(ct == ChatType.HANDEL) {
			Bukkit.broadcastMessage("§7[§6H§7] " + msg);
		}
	}

	public static void sendServerMessage(ChatType ct, String msg, String name) {
		if(ct == ChatType.GLOBAL) {
			Bukkit.broadcastMessage("§7[§dG§7] " + "" + name + "§7: " + msg);
		} else if(ct == ChatType.SUPPORT) {
			for(Player all : Bukkit.getOnlinePlayers()) {
				if(all.hasPermission("citybuild.chat.support")) {
					if(!ChatListener.togglesup.contains(all.getUniqueId())) {
						all.sendMessage("§7[§9§lSUP§r§7] " + name + "§7: " + msg);
					}
				}
			}
		} else if(ct == ChatType.HANDEL) {
			Bukkit.broadcastMessage("§7[§6H§7] " + name + "§7: " + msg);
		}
	}
}
