package net.bote.citybuild.drops;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import net.bote.citybuild.main.Main;

public class RocketDrop implements Listener {
	
	private Main plugin;
	
	private static ArrayList<Player> drop = new ArrayList<Player>();

	public RocketDrop(Main main) {
		this.plugin = main;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	// 1 = 2 sek
	// 2 = 3 sek
	// 3 = 3,5 sek
	
	@EventHandler
	public void onInt(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			try {
			String dis = p.getItemInHand().getItemMeta().getDisplayName();
				if(!drop.contains(p)) {
					if(dis.equalsIgnoreCase("§7Low-Drop")) {
						Location loc = p.getLocation();
						Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

							@Override
							public void run() {
								
								String world = loc.getWorld().getName();
								double x = loc.getX();
								double y = loc.getY() + 20;
								double z = loc.getZ();
								double yaw = loc.getYaw();
								double pitch = loc.getPitch();
								
								Location newloc = new Location(Bukkit.getWorld(world), x, y, z);
								newloc.setYaw((float) yaw);
								newloc.setPitch((float) pitch);
								
								
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomLowDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomLowDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomLowDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomLowDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomLowDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomLowDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomLowDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomLowDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomLowDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomLowDrop());
							}
							
						}, 20*2);
					}
					else if(dis.equalsIgnoreCase("§bUltra-Drop")) {
						Location loc = p.getLocation();
						Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

							@Override
							public void run() {
								
								String world = loc.getWorld().getName();
								double x = loc.getX();
								double y = loc.getY() + 20;
								double z = loc.getZ();
								double yaw = loc.getYaw();
								double pitch = loc.getPitch();
								
								Location newloc = new Location(Bukkit.getWorld(world), x, y, z);
								newloc.setYaw((float) yaw);
								newloc.setPitch((float) pitch);
								
								
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomUltraDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomUltraDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomUltraDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomUltraDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomUltraDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomUltraDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomUltraDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomUltraDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomUltraDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomUltraDrop());
							}
							
						}, 20*2);
					}
					else if(dis.equalsIgnoreCase("§6Champion-Drop")) {
						Location loc = p.getLocation();
						Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

							@Override
							public void run() {
								
								String world = loc.getWorld().getName();
								double x = loc.getX();
								double y = loc.getY() + 20;
								double z = loc.getZ() + 0.75;
								double yaw = loc.getYaw();
								double pitch = loc.getPitch();
								
								Location newloc = new Location(Bukkit.getWorld(world), x, y, z);
								newloc.setYaw((float) yaw);
								newloc.setPitch((float) pitch);
								
								
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomChampionDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomChampionDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomChampionDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomChampionDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomChampionDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomChampionDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomChampionDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomChampionDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomChampionDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomChampionDrop());
							}
							
						}, 20*2);
					}
					else if(dis.equalsIgnoreCase("§cSuper-Drop")) {
						Location loc = p.getLocation();
						Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

							@Override
							public void run() {
								
								String world = loc.getWorld().getName();
								double x = loc.getX() + 1.5;
								double y = loc.getY() + 20;
								double z = loc.getZ();
								double yaw = loc.getYaw();
								double pitch = loc.getPitch();
								
								Location newloc = new Location(Bukkit.getWorld(world), x, y, z);
								newloc.setYaw((float) yaw);
								newloc.setPitch((float) pitch);
								
								
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomSuperDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomSuperDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomSuperDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomSuperDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomSuperDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomSuperDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomSuperDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomSuperDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomSuperDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getRandomSuperDrop());
							}
							
						}, 20*2);
					}
					else if(dis.equalsIgnoreCase("§4§lMEGA-Drop")) {
						Location loc = p.getLocation();
						for(Player all : Bukkit.getOnlinePlayers()) {
							Drops.sendPortMessage(all, p);
							all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 3F, 3F);
						}
						Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

							@Override
							public void run() {
								
								String world = loc.getWorld().getName();
								double x = loc.getX();
								double y = loc.getY() + 20;
								double z = loc.getZ() + 1;
								double yaw = loc.getYaw();
								double pitch = loc.getPitch();
								
								Location newloc = new Location(Bukkit.getWorld(world), x, y, z);
								newloc.setYaw((float) yaw);
								newloc.setPitch((float) pitch);
								
								
								Bukkit.getWorld(world).dropItem(newloc, Drops.getMegaDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getMegaDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getMegaDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getMegaDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getMegaDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getMegaDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getMegaDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getMegaDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getMegaDrop());
								Bukkit.getWorld(world).dropItem(newloc, Drops.getMegaDrop());
							}
							
						}, 10*7);
					} else {
						// hai
					}
					drop.add(p);
					Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
						
						@Override
						public void run() {
							
							drop.remove(p);
							
						}
					}, 20*5);
				} else {
					p.sendMessage("§cWarte kurz, bis du wieder einen Drop zündest!");
				}
			} catch (NullPointerException ignored) {
				
			}
		} else {
			// hai
		}
	}

}
