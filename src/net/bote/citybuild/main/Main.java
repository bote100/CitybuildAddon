package net.bote.citybuild.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.bote.citybuild.addons.CMD_pe;
import net.bote.citybuild.addons.CMD_vanish;
import net.bote.citybuild.addons.PlotEdit;
import net.bote.citybuild.addons.handeln.CMD_handelnaccept;
import net.bote.citybuild.addons.handeln.CMD_handlnn;
import net.bote.citybuild.addons.handeln.HandelListener;
import net.bote.citybuild.api.Citybuild;
import net.bote.citybuild.chat.ChatListener;
import net.bote.citybuild.chats.CMD_handeln;
import net.bote.citybuild.chats.CMD_msg;
import net.bote.citybuild.chats.CMD_r;
import net.bote.citybuild.chats.CMD_support;
import net.bote.citybuild.chats.CMD_togglemsg;
import net.bote.citybuild.chats.CMD_togglesup;
import net.bote.citybuild.commands.CMD_Warp;
import net.bote.citybuild.commands.CMD_addwarp;
import net.bote.citybuild.commands.CMD_near;
import net.bote.citybuild.commands.CMD_setWarp;
import net.bote.citybuild.crates.CMD_crates;
import net.bote.citybuild.crates.CMD_givecrates;
import net.bote.citybuild.crates.CrateListener;
import net.bote.citybuild.crates.JoinListener;
import net.bote.citybuild.drops.CMD_dropport;
import net.bote.citybuild.drops.CMD_drops;
import net.bote.citybuild.drops.RocketDrop;
import net.bote.citybuild.startkick.utils.CMD_ja;
import net.bote.citybuild.startkick.utils.CMD_nein;
import net.bote.citybuild.startkick.utils.CMD_startkick;
import net.bote.citybuild.startkick.utils.Data;
import net.bote.citybuild.startkick.utils.SKManager;
import net.bote.citybuild.voteday.CMD_dayja;
import net.bote.citybuild.voteday.CMD_daynein;
import net.bote.citybuild.voteday.CMD_voteday;
import net.bote.citybuild.voteday.VoteDayManager;
import net.bote.citybuild.warp.WarpManager;

public class Main extends JavaPlugin {
	
	private static Main instance;
	
	public static String StartKickPrefix = "§4StartKick §7| ";
	
	public static HashMap<UUID, UUID> lastSender = new HashMap<>();
	
	public static ArrayList<Player>	handelt = new ArrayList<Player>();
	
	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	public static ArrayList<Player> vanish = new ArrayList<Player>();
	
	private static int i = 0;
	
	@Override
	public void onEnable() {
		instance = this;
		try {
			start();
			CMD_vanish.load();
		} catch (NullPointerException ignored) {
			
		}
		Main.getAPI().setStartkickAvaible(true);
		
		Data.novote = 0;
		Data.yesvotes = 0;
		Main.getData().StartKickState = false;
		VoteDayManager.laod();
		
		registerEvents();
		
		// Random Shit
		this.getCommand("setwarp").setExecutor(new CMD_setWarp(this));
		this.getCommand("warp").setExecutor(new CMD_Warp(this));
		this.getCommand("w").setExecutor(new CMD_Warp(this));
		this.getCommand("near").setExecutor(new CMD_near(this));
		this.getCommand("pe").setExecutor(new CMD_pe(this));
		this.getCommand("addwarp").setExecutor(new CMD_addwarp(this));
		
		this.getCommand("v").setExecutor(new CMD_vanish(this));
		this.getCommand("vanish").setExecutor(new CMD_vanish(this));
		
		// Handeln
		this.getCommand("handeln").setExecutor(new CMD_handlnn(this));
		this.getCommand("handelnaccept").setExecutor(new CMD_handelnaccept(this));
		
		// StartKick
		this.getCommand("startkick").setExecutor(new CMD_startkick(this));
		this.getCommand("ja").setExecutor(new CMD_ja(this));
		this.getCommand("nein").setExecutor(new CMD_nein(this));
		
		// Voteday
		this.getCommand("voteday").setExecutor(new CMD_voteday(this));
		this.getCommand("daynein").setExecutor(new CMD_daynein(this));
		this.getCommand("dayja").setExecutor(new CMD_dayja(this));
		
		// Drops
		this.getCommand("dropport").setExecutor(new CMD_dropport(this));
		this.getCommand("drops").setExecutor(new CMD_drops(this));
		
		// Crates
		this.getCommand("crates").setExecutor(new CMD_crates(this));
		this.getCommand("givecrates").setExecutor(new CMD_givecrates(this));
		
		// Chats
		this.getCommand("support").setExecutor(new CMD_support(this));
		this.getCommand("h").setExecutor(new CMD_handeln(this));
		this.getCommand("s").setExecutor(new CMD_support(this));
		this.getCommand("sup").setExecutor(new CMD_support(this));
		this.getCommand("togglemsg").setExecutor(new CMD_togglemsg(this));
		this.getCommand("togglesup").setExecutor(new CMD_togglesup(this));
		this.getCommand("togglesupport").setExecutor(new CMD_togglesup(this));
		this.getCommand("msg").setExecutor(new CMD_msg(this));
		this.getCommand("reply").setExecutor(new CMD_r(this));
		this.getCommand("r").setExecutor(new CMD_r(this));
		
	}
	
	@Override
	public void onDisable() {
		
	}
 
	private void registerEvents() {
		new RocketDrop(this);
		new CrateListener(this);
		new ChatListener(this);
		new SKManager(this);
		new PlotEdit(this);
		new HandelListener(this);
		new JoinListener(this);
	}
	// Getter
	
	
	public static Citybuild getAPI() {
		return new Citybuild();
	}
	
	public static Main getInstance() {
		return Main.instance;
	}
	
	public static Data getData() {
		return new Data();
	}
	
	public static WarpManager getWarpManager() {
		return new WarpManager();
	}
	
	public void start() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {
				
				if(i == 0) {
					i = 1;
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("§eInfo: §7Mit §6/h §7könnt ihr im Handelschat schreiben. Mit §6/handeln §7könnt ihr handeln");
					Bukkit.broadcastMessage("");
				} else if(i == 1) {
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("§7Wir haben verschiedene Chats! Nutze: §9/s§7, §6/h§7 oder §e/msg");
					Bukkit.broadcastMessage("");
					i = 2;
				} else if(i == 2) {
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("§7In §cCrates §7kannst du tolle Items gewinnen!");
					Bukkit.broadcastMessage("");
					i = 3;
				} else if(i == 3) {
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("§7Mit §e/near §7kannst du den nahe Spieler ausfindig machen!");
					Bukkit.broadcastMessage("");
					i = 0;
				}
				
			}
			
		}, 20L, 20*60*5);
	}
}
