package net.bote.citybuild.chat;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.bote.citybuild.api.ChatSystem;
import net.bote.citybuild.main.Main;
import net.bote.citybuild.main.Var;

public class ChatListener implements Listener {
	
	private Main plugin;
	
	public static ArrayList<UUID> togglemsg = new ArrayList<UUID>();
	public static ArrayList<UUID> togglesup = new ArrayList<UUID>();

	public ChatListener(Main main) {
		this.plugin = main;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		String msg = e.getMessage();
		e.setCancelled(true);
		if(msg.toLowerCase().contains("wurde gescammt")) {
			e.getPlayer().sendMessage(help());
		} else if(msg.toLowerCase().contains("wo kann man sich bewerben?")) {
			e.getPlayer().sendMessage(help());
		} else if(msg.toLowerCase().contains("wie kann man")) {
			e.getPlayer().sendMessage(help());
		} else {
			ChatSystem.sendServerMessage(ChatType.GLOBAL, msg, e.getPlayer().getDisplayName());
		}
	}

	private static String help() {
		return Var.cb+"§7Wenn du Hilfe benötigst, kannst du mit §9/s <Deine Nachricht> §7,§lSupporter §r§7kontaktieren";
	}
}
