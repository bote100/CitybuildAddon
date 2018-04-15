package net.bote.citybuild.crates;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import net.bote.citybuild.drops.Drops;

public class Crates {
	
	public static String prefix = "§cCrates §7§l| §r";
	
	public static ArrayList<Player> list = new ArrayList<Player>();
	
	public static void openInventory(Player p, CrateType ct) {
		
		if(ct == CrateType.Player_Crate) {
			Inventory inv = Bukkit.createInventory(null, 9*6, "§7Spieler Crate");
			
			for(int i = 0; i < 9*6; i++) {
				inv.setItem(i, Drops.createItem(Material.STAINED_GLASS_PANE, "§7Klick mich und gewinne!"));
			}
			
			p.openInventory(inv);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 3, 3);
		}
		if(ct == CrateType.Legend_Crate) {
			Inventory inv = Bukkit.createInventory(null, 9*6, "§2Legend Crate");
			
			for(int i = 0; i < 9*6; i++) {
				inv.setItem(i, Drops.createItem(Material.STAINED_GLASS_PANE, "§7Klick mich und gewinne!"));
			}
			
			p.openInventory(inv);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 3, 3);
		}
		if(ct == CrateType.Ultra_Crate) {
			Inventory inv = Bukkit.createInventory(null, 9*6, "§bUltra Crate");
			
			for(int i = 0; i < 9*6; i++) {
				inv.setItem(i, Drops.createItem(Material.STAINED_GLASS_PANE, "§7Klick mich und gewinne!"));
			}
			
			p.openInventory(inv);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 3, 3);
		}
		if(ct == CrateType.Champion_Crate) {
			Inventory inv = Bukkit.createInventory(null, 9*6, "§cChampion Crate");
			
			for(int i = 0; i < 9*6; i++) {
				inv.setItem(i, Drops.createItem(Material.STAINED_GLASS_PANE, "§7Klick mich und gewinne!"));
			}
			
			p.openInventory(inv);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 3, 3);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack createItem(int type, int anzahl, String dis) {
		ItemStack i = new ItemStack(type, anzahl);
		ItemMeta m = i.getItemMeta();
		m.setDisplayName(dis);
		i.setItemMeta(m);
		return i;
	}
	
	public static ItemStack createItem(Material mat, int anzahl, String dis) {
		ItemStack i = new ItemStack(mat, anzahl);
		ItemMeta m = i.getItemMeta();
		m.setDisplayName(dis);
		i.setItemMeta(m);
		return i;
	}
	
	public static ItemStack giveCrate(CrateType type, int anzahl) {
		if(type == CrateType.Player_Crate) {
			return Crates.createSkull(anzahl, "§7Spieler Crate", "MHF_Chest");
		} else if(type == CrateType.Legend_Crate) {
			return Crates.createSkull(anzahl, "§2Legend Crate", "MHF_Chest");
		} else if(type == CrateType.Ultra_Crate) {
			return Crates.createSkull(anzahl, "§bUltra Crate", "MHF_Chest");
		} else if(type == CrateType.Champion_Crate) {
			return Crates.createSkull(anzahl, "§c§lChampion Crate", "MHF_Chest");
		} else {
			return null;
		}
	}
	
	public static void openAdminInv(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9, "§4Admin §cCrates");
		inv.setItem(0, Crates.createSkull(64, "§7Spieler Crate", "MHF_Chest"));
		inv.setItem(1, Crates.createSkull(64, "§2Legend Crate", "MHF_Chest"));
		inv.setItem(2, Crates.createSkull(64, "§bUltra Crate", "MHF_Chest"));
		inv.setItem(3, Crates.createSkull(64, "§c§lChampion Crate", "MHF_Chest"));
		p.openInventory(inv);
	}
	
	
	public static ItemStack createSkull(int anzahl, String dis, String name) {
		 ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, anzahl, (short) 3);
	     SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
	     meta.setOwner(name);
	     meta.setDisplayName(dis);
	     itemStack.setItemMeta(meta);
	     return itemStack;
	}

	public static ItemStack getUltraCrate() {
		Random r = new Random();
		int i = r.nextInt(11);
		
		switch (i) {
		case 0:
			return new ItemStack(Material.DIAMOND, 4);
		case 1:
			return new ItemStack(Material.EMERALD, 4);
		case 2:
			return new ItemStack(Material.WOOD, 64);
		case 3:
			return new ItemStack(Material.COOKED_BEEF, 32);
		case 4:
			return new ItemStack(Material.GOLDEN_APPLE);
		case 5:
			return createItem(Material.YELLOW_FLOWER, 1, "§61000 Coins");
		case 6:
			return new ItemStack(Material.IRON_PICKAXE);
		case 7:
			return new ItemStack(Material.IRON_INGOT, 16);
		case 8:
			return new ItemStack(Material.SNOW_BLOCK, 16);
		case 9:
			return createItem(Material.IRON_CHESTPLATE, 1, "§b§lUltra §r§bBrustplatte");
		case 10:
			return createItem(Material.YELLOW_FLOWER, 1, "§6500 Coins");
		default:
			return new ItemStack(Material.ROTTEN_FLESH);
		}
	}
	
	public static ItemStack getChampionCrate() {
		Random r = new Random();
		int i = r.nextInt(10);
		
		switch (i) {
		case 0:
			return new ItemStack(Material.DIAMOND_BLOCK);
		case 1:
			return new ItemStack(Material.GOLDEN_APPLE, 16);
		case 2:
			return new ItemStack(Material.DIAMOND_HOE);
		case 3:
			return createItem(Material.YELLOW_FLOWER, 1, "§61000 Coins");
		case 4:
			return new ItemStack(Material.CAKE);
		case 5:
			return new ItemStack(Material.IRON_PICKAXE);
		case 6:
			return new ItemStack(Material.EMERALD_BLOCK);
		case 7:
			return new ItemStack(Material.IRON_INGOT, 32);
		case 8:
			return new ItemStack(Material.DIAMOND_ORE, 8);
		case 9:
			return createItem(Material.YELLOW_FLOWER, 1, "§6500 Coins");
		case 10:
			return new ItemStack(Material.IRON_SWORD);
		default:
			return new ItemStack(Material.ROTTEN_FLESH);
		}
	}
	
}
