package net.bote.citybuild.startkick.utils;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;

public class Data {
	
	public static int yesvotes = 0;
	
	public static int novote = 0;
	
	public static boolean StartKickState = false;
	
	public static ArrayList<String> banneduuid = new ArrayList<String>();
	public static ArrayList<String> startkick_vote = new ArrayList<String>();
	
	
	// TPA
	public static HashMap<Player, Player> tpa = new HashMap<Player, Player>();

}
