package net.bote.citybuild.crates;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.CommandException;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import net.bote.citybuild.drops.Drops;
import net.bote.citybuild.main.Main;

public class CrateListener implements Listener {
	
	private Main plugin;
	
	public static int amount = 0;

	public CrateListener(Main main) {
		this.plugin = main;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onCrate(PlayerInteractEvent e) {
		Player p = e.getPlayer();
			String dis = e.getItem().getItemMeta().getDisplayName();
			if(e.getAction() == Action.RIGHT_CLICK_AIR) {
				e.setCancelled(false);
					try {
						if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7Spieler Crate")) {
							Crates.openInventory(p, CrateType.Player_Crate);
							Crates.list.add(p);
							removeItem(p, createSkull(dis, "MHF_Chest"), p.getItemInHand().getType(), dis, plugin);
							p.updateInventory();
						} else if(dis.equalsIgnoreCase("�2Legend Crate")){
							Crates.openInventory(p, CrateType.Legend_Crate);
							Crates.list.add(p);
							removeItem(p, createSkull(dis, "MHF_Chest"), p.getItemInHand().getType(), dis, plugin);
							p.updateInventory();
						} else if(dis.equalsIgnoreCase("�bUltra Crate")) {
							Crates.openInventory(p, CrateType.Ultra_Crate);
							Crates.list.add(p);
							removeItem(p, createSkull(dis, "MHF_Chest"), p.getItemInHand().getType(), dis, plugin);
							p.updateInventory();
						} else if(dis.equalsIgnoreCase("�c�lChampion Crate")) {
							Crates.openInventory(p, CrateType.Champion_Crate);
							Crates.list.add(p);
							
							removeItem(p, createSkull(dis, "MHF_Chest"), p.getItemInHand().getType(), dis, plugin);
							p.updateInventory();
						}
					} catch (NullPointerException ignored) {
						
					}
			} else if(e.getAction() == Action.RIGHT_CLICK_BLOCK && isCrate(e.getItem())) {
				e.setCancelled(true);
				p.sendMessage("�9Citybuild �7| �cDu kannst keine Crates platzieren!");
			} else if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
				try {
					
					if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7Spieler Crate")) {
						Inventory inv = Bukkit.createInventory(null, 9*3, "�6�lDu kannst gewinnen:");
						inv.setItem(0, new ItemStack(Material.DIAMOND));
						inv.setItem(1, new ItemStack(Material.APPLE));
						inv.setItem(2, new ItemStack(Material.WOOD, 16));
						inv.setItem(3, new ItemStack(Material.BREAD, 16));
						inv.setItem(4, new ItemStack(Material.EGG));
						inv.setItem(5, new ItemStack(Material.WOOD_HOE));
						inv.setItem(6, new ItemStack(Material.IRON_INGOT, 8));
						inv.setItem(7, new ItemStack(Material.SNOW_BLOCK));
						inv.setItem(8, new ItemStack(Material.STONE_PICKAXE));
						inv.setItem(9, new ItemStack(Material.CARROT_ITEM));
						inv.setItem(10, new ItemStack(Material.SNOW_BLOCK));
						inv.setItem(11, Drops.createFireWork("�7Low-Drop", 64, Color.GRAY, 1));
						p.openInventory(inv);
					} else if(dis.equalsIgnoreCase("�2Legend Crate")){
						Inventory inv = Bukkit.createInventory(null, 9*3, "�6�lDu kannst gewinnen:");
						inv.setItem(0, new ItemStack(Material.DIAMOND, 4));
						inv.setItem(1, new ItemStack(Material.EMERALD));
						inv.setItem(2, new ItemStack(Material.WOOD, 64));
						inv.setItem(3, new ItemStack(Material.COOKED_BEEF, 32));
						inv.setItem(4, new ItemStack(Material.CACTUS));
						inv.setItem(5, new ItemStack(Material.CARROT_ITEM));
						inv.setItem(6, new ItemStack(Material.IRON_INGOT, 16));
						inv.setItem(7, new ItemStack(Material.SNOW_BLOCK, 16));
						inv.setItem(8, new ItemStack(Material.BOOK));
						inv.setItem(9, Drops.createFireWork("�bUltra-Drop", 4, Color.AQUA, 1));
						p.openInventory(inv);
					} else if(dis.equalsIgnoreCase("�bUltra Crate")) {
						Inventory inv = Bukkit.createInventory(null, 9*3, "�6�lDu kannst gewinnen:");
						inv.setItem(0, new ItemStack(Material.DIAMOND, 4));
						inv.setItem(1, new ItemStack(Material.EMERALD, 4));
						inv.setItem(2, new ItemStack(Material.WOOD, 64));
						inv.setItem(3, new ItemStack(Material.COOKED_BEEF, 32));
						inv.setItem(4, new ItemStack(Material.GOLDEN_APPLE));
						inv.setItem(5, Crates.createItem(Material.YELLOW_FLOWER, 1, "�61000 Coins"));
						inv.setItem(6, new ItemStack(Material.IRON_PICKAXE));
						inv.setItem(7, new ItemStack(Material.SNOW_BLOCK, 16));
						inv.setItem(8, new ItemStack(Material.IRON_INGOT, 16));
						inv.setItem(9, Crates.createItem(Material.IRON_CHESTPLATE, 1, "�b�lUltra �r�bBrustplatte"));
						inv.setItem(10, Crates.createItem(Material.YELLOW_FLOWER, 1, "�6500 Coins"));
						p.openInventory(inv);
					} else if(dis.equalsIgnoreCase("�c�lChampion Crate")) {
						Inventory inv = Bukkit.createInventory(null, 9*3, "�6�lDu kannst gewinnen:");
						inv.setItem(0, new ItemStack(Material.DIAMOND_BLOCK));
						inv.setItem(1, new ItemStack(Material.GOLDEN_APPLE, 16));
						inv.setItem(2, new ItemStack(Material.DIAMOND_HOE));
						inv.setItem(3, Crates.createItem(Material.YELLOW_FLOWER, 1, "�61000 Coins"));
						inv.setItem(4, new ItemStack(Material.CAKE));
						inv.setItem(5, new ItemStack(Material.IRON_PICKAXE));
						inv.setItem(6, new ItemStack(Material.IRON_INGOT, 32));
						inv.setItem(7, new ItemStack(Material.DIAMOND_ORE, 8));
						inv.setItem(8, Crates.createItem(Material.YELLOW_FLOWER, 1, "�6500 Coins"));
						inv.setItem(9, new ItemStack(Material.IRON_SWORD));
						inv.setItem(10, new ItemStack(Material.SNOW_BLOCK));
						inv.setItem(11, Drops.createFireWork("�7Low-Drop", 64, Color.GRAY, 1));
						p.openInventory(inv);
					}
					
				} catch (NullPointerException ignored) {
					
				}
			}
	}
	
	private boolean isCrate(ItemStack i) {
		try {
			if(i.getItemMeta().getDisplayName().equalsIgnoreCase("�7Spieler Crate") ||
					i.getItemMeta().getDisplayName().equalsIgnoreCase("�2Legend Crate") ||
					i.getItemMeta().getDisplayName().equalsIgnoreCase("�bUltra Crate") ||
					i.getItemMeta().getDisplayName().equalsIgnoreCase("�c�lChampion Crate")) {
				return true;
			} else {
				return false;
			}
		} catch (NullPointerException ignored) {
			return false;
		}
	}
	
	private static ItemStack createSkull(int anzahl, String dis, String name) {
		 ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, anzahl, (short) 3);
	     SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
	     meta.setOwner(name);
	     meta.setDisplayName(dis);
	     itemStack.setItemMeta(meta);
	     return itemStack;
	}
	
	private static ItemStack createSkull(String dis, String name) {
		 ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
	     SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
	     meta.setOwner(name);
	     meta.setDisplayName(dis);
	     itemStack.setItemMeta(meta);
	     return itemStack;
	}
	
	private static void removeItem(Player p, ItemStack is, Material mat, String dis, Plugin pl) {
		amount = 0;
		for(ItemStack item : p.getInventory().getContents()) {
			try {
				if(item.getItemMeta().getDisplayName().equalsIgnoreCase(dis)) {
					amount += item.getAmount();
					
					amount = amount - 1;
					p.getInventory().removeItem(p.getItemInHand());
					Bukkit.getScheduler().runTaskLater(pl, new Runnable() {

						@Override
						public void run() {
							p.getInventory().setItemInHand(createSkull(amount, dis, "MHF_Chest"));
						}
						
					}, 1);
					
				}
			} catch (NullPointerException ignored) {
			}
		}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(e.getInventory().getName().contains("�aCase�dOpening")) {
			e.setCancelled(true);
			Player p = (Player)e.getWhoClicked();
			if(Crates.list.contains(p)) {
				try {
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7Klick mich und gewinne!")) {
						
						int i = e.getSlot();
						if(e.getInventory().getName().equalsIgnoreCase("�aCase�dOpening �8- �7Spieler Crate")) {
							ItemStack is = Drops.getRandomLowDrop();
							e.getInventory().setItem(i, is);
							sendWinMessage(is, p);
							p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 3, 3);
							p.getInventory().addItem(is);
							Crates.list.remove(p);
							e.getInventory().remove(Material.STAINED_GLASS_PANE);
						} else if(e.getInventory().getName().equalsIgnoreCase("�aCase�dOpening �8- �2Lgnd Crate")) {
							ItemStack is = Drops.getRandomUltraDrop();
							e.getInventory().setItem(i, is);
							sendWinMessage(is, p);
							p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 3, 3);
							p.getInventory().addItem(is);
							Crates.list.remove(p);
							e.getInventory().remove(Material.STAINED_GLASS_PANE);
						} else if(e.getInventory().getName().equalsIgnoreCase("�aCase�dOpening �8- �bUltra Crate")) {
							ItemStack is = Crates.getChampionCrate();
							try {
								if(is.getItemMeta().getDisplayName().equalsIgnoreCase("�6500 Coins")) {
									p.sendMessage(Crates.prefix+"�aDu hast �6500 Coins �agewonnen!");
									e.getInventory().setItem(i, is);
									Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "money give " + p.getName() + " 500");
								} else if(is.getItemMeta().getDisplayName().equalsIgnoreCase("�61000 Coins")) {
									p.sendMessage(Crates.prefix+"�aDu hast �61000 Coins �agewonnen!");
									e.getInventory().setItem(i, is);
									Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "money give " + p.getName() + " 1000");
								} else {
									sendWinMessage(is, p);
									p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 3, 3);
									p.getInventory().addItem(is);
								}
							} catch (CommandException | NullPointerException ignored) {
								sendWinMessage(is, p);
								p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 3, 3);
								p.getInventory().addItem(is);
							}
							e.getInventory().setItem(i, is);
							Crates.list.remove(p);
							e.getInventory().remove(Material.STAINED_GLASS_PANE);
						} else if(e.getInventory().getName().equalsIgnoreCase("�aCase�dOpening �8- �cChamp Crate")) {
							ItemStack is = Crates.getChampionCrate();
							try {
								if(is.getItemMeta().getDisplayName().equalsIgnoreCase("�6500 Coins")) {
									p.sendMessage(Crates.prefix+"�aDu hast �6500 Coins �agewonnen!");
									e.getInventory().setItem(i, is);
									Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "money give " + p.getName() + " 500");
								} else if(is.getItemMeta().getDisplayName().equalsIgnoreCase("�61000 Coins")) {
									p.sendMessage(Crates.prefix+"�aDu hast �61000 Coins �agewonnen!");
									e.getInventory().setItem(i, is);
									Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "money give " + p.getName() + " 1000");
								} else {
									sendWinMessage(is, p);
									p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 3, 3);
									p.getInventory().addItem(is);
								}
							} catch (CommandException | NullPointerException ignored) {
								sendWinMessage(is, p);
								p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 3, 3);
								p.getInventory().addItem(is);
							}
							e.getInventory().setItem(i, is);
							Crates.list.remove(p);
							e.getInventory().remove(Material.STAINED_GLASS_PANE);
						}
					}
				} catch(NullPointerException ignored) {
					
				}
			}
		}
	}
	
	public static void sendWinMessage(ItemStack is, Player p) {
		if(is != null && is.getItemMeta().getDisplayName() != null) {
			p.sendMessage(Crates.prefix+"�aDu hast �6" + is.getItemMeta().getDisplayName() + " �agewonnen!");
		}
	}
	
}