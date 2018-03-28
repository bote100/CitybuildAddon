package net.bote.citybuild.main;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class Var {
	
	public static String vdprefix = "§6VoteDay §7§l| §r";
	
	public static String cb = "§9Citybuild §7| ";
	
	public static void sendVoteDayHelp(Player p) {
		p.sendMessage(vdprefix+"§cNutze: /voteday <Tag | Nacht> <Dauer der Abstimmung [1-9]>");
	}
	
	public static HashMap<String, String> werbung = new HashMap<String, String>();

}
