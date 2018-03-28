package net.bote.citybuild.api;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import net.bote.citybuild.main.Main;
import net.bote.citybuild.main.Var;
import net.bote.citybuild.startkick.utils.Data;
import net.bote.citybuild.voteday.VoteDayManager;
import net.bote.citybuild.voteday.VoteDayState;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Citybuild {
	
	
	// Startkick API
	
	private static boolean vd = true;
	
	public static void setStartkickAvaible(boolean bol) {
		Main.getData().StartKickState = bol;
	}
	
	public static boolean isStartkickAvaible() {
		return Main.getData().StartKickState;
	}
	
	public static boolean isVoteDayAvaible() {
		return vd;
	}
	
	public static void setVoteDayStatus(boolean bol) {
		vd = bol;
	}
		
	public static void startKick(Player p, Player target, int time, Plugin plugin) {
			if(target != null) {
				if(time > 0 && time <= 11) {
					if(!Citybuild.isStartkickAvaible()) {
						if(!target.hasPermission("citybuild.startkick.bypass")) {
							if(p.getUniqueId() != target.getUniqueId()) {

								p.sendMessage(Main.StartKickPrefix+"§2Du hast einen StartKick erstellt!");
								Citybuild.setStartkickAvaible(false);
								Bukkit.broadcastMessage("§7Der Spieler §5§l" + target.getName() + " §r§7soll rausgeworfen werden!");
								if(p.getName() != "bote100") {
									if(time > 1) {
										Bukkit.broadcastMessage("§7Infos: §eLänge §5>> §e" + time + " Minuten");
									} else {
										Bukkit.broadcastMessage("§7Infos: §eLänge §5>> §e1 Minute");
									}
								} else {
									if(time > 1) {
										Bukkit.broadcastMessage("§7Infos: §eLänge §5>> §e" + time + " Minuten §5| §eErsteller >> §e" + p.getName());
									} else {
										Bukkit.broadcastMessage("§7Infos: §eLänge §5>> §e1 Minute §5| §eErsteller >> §e" + p.getName());
									}
								}
											
								Bukkit.broadcastMessage("§7 ");
								
								for(Player all : Bukkit.getOnlinePlayers()) {
									sendVoteMessage(all);
									all.playSound(all.getLocation(), Sound.ENDERDRAGON_GROWL, 3, 3);
								}
											Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

												@Override
												public void run() {
													
													for(Player all : Bukkit.getOnlinePlayers()) {
														all.playSound(all.getLocation(), Sound.ANVIL_USE, 3, 3);
													}
													Bukkit.broadcastMessage(Main.StartKickPrefix+"§bDer StartKick von " + target.getName() + " ist nun vorbei!");
													Bukkit.broadcastMessage(Main.StartKickPrefix+"§bEs gab §a§l" + Main.getData().yesvotes + " Votes für JA §bund §c§l" + Main.getData().novote + " Votes für NEIN");
													
													if(Main.getData().yesvotes > Main.getData().novote) {
														Bukkit.broadcastMessage(Main.StartKickPrefix+"§bSomit wurde " + target.getName() + " §lfür 5 Minuten rausgeworfen!");
														String uuid = target.getUniqueId().toString();
														Main.getData().banneduuid.add(uuid);
														target.kickPlayer(Main.StartKickPrefix+"§bDu wurdest für 5 Minuten rausgeworfen!");
														Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

															@Override
															public void run() {
																Main.getData().banneduuid.clear();
															}
															
														}, 20*60*5);
														Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

															@Override
															public void run() {
																Citybuild.setStartkickAvaible(true);
															}
															
														}, 20*60*10);
														
													} else {
														Bukkit.broadcastMessage(Main.StartKickPrefix+"§7Somit wurde " + target.getName() + " verschont.");
													}
													
													Main.getData().yesvotes = 0;
													Main.getData().novote = 0;
													Data.startkick_vote.clear();
												} 
												
											}, 20*60*time); // Zeit
											
										} else {
											p.sendMessage(Main.StartKickPrefix+"§Du kannst dich nicht selber kicken!");
										}
						} else {
							p.sendMessage(Main.StartKickPrefix+"§cDu kannst diesen Spieler nicht startkicken!");
						}
							} else {
								p.sendMessage(Main.StartKickPrefix+"§cEs kann im Moment kein StartKick gestartet werden! Bitte versuche es später erneut!");
							}
					
					} else {
						p.sendMessage(Main.StartKickPrefix+"§cBitte nehme eine kleinere Zahl (1-10)");
					}
				
			} else {
				p.sendMessage(Main.StartKickPrefix+"§cDieser Spieler ist offline.");
			}
	}
	
	private static void sendVoteMessage(Player p) {

		TextComponent ja = new TextComponent("§a/ja");
		ja.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/ja"));
		ja.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aKlicke um für JA zu stimmen!").create()));
		
		TextComponent no = new TextComponent("§c/nein");
		no.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/nein"));
		no.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cKlicke um für NEIN zu stimmen!").create()));
		
		TextComponent txt = new TextComponent("  §7|§r ");
		TextComponent msg = new TextComponent("§7Stimme mit Klicken oder mit ");
		TextComponent msg2 = new TextComponent(" §7ab!");
		msg.addExtra(ja);
		msg.addExtra(txt);
		msg.addExtra(no);
		msg.addExtra(msg2);
		
		p.spigot().sendMessage(msg);
	}
	
	//
	
	
	public static void createVoteDay(Player p, int time, VoteDayState state, Plugin plugin) {
		if(p.hasPermission("voteday.use")) {
				if(isVoteDayAvaible()) {
					if(time > 0 && time <= 10) {
						Citybuild.setVoteDayStatus(false);
						
						String world = p.getLocation().getWorld().getName();
						
						String motto = "";
						
						if(state == VoteDayState.TAG) {
							motto = "Tag";
						} else {
							motto = "Nacht";
						}
						
						Bukkit.broadcastMessage("§7§lEs soll §b" + motto + " §7werden!");
						if(time == 1) {
							Bukkit.broadcastMessage("§7Du kannst §2§l1 Minute lang §r§7abstimmen!");
						} else {
							Bukkit.broadcastMessage("§7Du kannst §2§l" + time + " Minuten lang §r§7abstimmen!");
						}
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.playSound(all.getLocation(), Sound.ANVIL_BREAK, 3, 3);
							sendVoteDayMessage(all);
						}
						
						Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

							@Override
							public void run() {
								
								Bukkit.broadcastMessage(Var.vdprefix+"§eDie VoteDay Abstimmung ist nun vorbei!");
								Bukkit.broadcastMessage(Var.vdprefix+"§bEs gab §a§l" + VoteDayManager.VOTEDAY_YES + " Votes für JA §bund §c§l" + VoteDayManager.VOTEDAY_NO + " Votes für NEIN");
								
								
								if(state == VoteDayState.TAG) {
									if(VoteDayManager.VOTEDAY_YES >= VoteDayManager.VOTEDAY_NO) {
										Bukkit.broadcastMessage(Var.vdprefix+"§7Es wird nun Tag!");
										
										Bukkit.getWorld(world).setTime(1000);
										Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "weather clear");
									} else {
										Bukkit.broadcastMessage(Var.vdprefix+"§7Das Wetter ändert sich nun §cnicht");
									}
								} else if(state == VoteDayState.NACHT) {
									if(VoteDayManager.VOTEDAY_YES >= VoteDayManager.VOTEDAY_NO) {
										Bukkit.broadcastMessage(Var.vdprefix+"§7Es wird nun §0Nacht");
										Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "weather clear");
										Bukkit.getWorld(world).setTime(15100);
									} else {
										Bukkit.broadcastMessage(Var.vdprefix+"§7Das Wetter ändert sich nun §cnicht");
									}
								}
								
								VoteDayManager.VOTEDAY_NO = 0;
								VoteDayManager.VOTEDAY_YES = 0;
								
								Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

									@Override
									public void run() {
										Citybuild.setVoteDayStatus(true);
									}
									
								}, 20*60*5);
							}
							
						}, 20*60*time);
				
						} else {
							Var.sendVoteDayHelp(p);
						}
				} else {
					p.sendMessage(Var.vdprefix+"§cZur Zeit kann kein VoteDay gestartet werden!");
				}
		} else {
			p.sendMessage(Var.vdprefix+"§cDu benötigst §leinen höheren Rang§r§c, um VoteDay's erstellen zu können!");
		}
	}
	
	private static void sendVoteDayMessage(Player p) {

		TextComponent ja = new TextComponent("§a/dayja");
		ja.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/dayja"));
		ja.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aKlicke um für JA zu stimmen!").create()));
		
		TextComponent no = new TextComponent("§c/daynein");
		no.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/daynein"));
		no.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cKlicke um für NEIN zu stimmen!").create()));
		
		TextComponent txt = new TextComponent("  §7|§r ");
		TextComponent msg = new TextComponent("§7Stimme mit Klicken oder mit ");
		TextComponent msg2 = new TextComponent(" §7ab!");
		msg.addExtra(ja);
		msg.addExtra(txt);
		msg.addExtra(no);
		msg.addExtra(msg2);
		
		p.spigot().sendMessage(msg);
	}
	
	public static Player getNearestPlayer(Player arg0) {
		double distance = Double.MAX_VALUE;
		Player target = null;
		
		for(Entity e : arg0.getNearbyEntities(500, 500, 500)) {
			if(e instanceof Player) {
				double dis = arg0.getLocation().distance(e.getLocation());
				if(dis < distance) {
					distance = dis;
					target = (Player)e;
				}
			}
		}
		return target;
	}
	
	// Adversitement
	
	public static String getAdOfPlayer(String name) {
		if(Citybuild.hasAd(name)) {
			return Var.werbung.get(name);
		} else {
			return null;
		}
	}
	
	public static void setAd(Player p, String ad, Plugin pl) {
		if(!Citybuild.hasAd(p.getName())) {
			Var.werbung.put(p.getName(), ad);
			Bukkit.getScheduler().runTaskLater(pl, new Runnable() {

				@Override
				public void run() {
					
					Var.werbung.remove(p.getName());
				}
				
			}, 20*5);
		} else {
			p.sendMessage("§eAd§8-§dMania §7| §cDu hast bereits eine Werbung geschaltet!");
		}
	}
	
	public static boolean hasAd(String name) {
		return Var.werbung.get(name) != null;
	}

	//
	
	public static void removeAd(String name) {
		Var.werbung.remove(name);
	}
	
	
}
