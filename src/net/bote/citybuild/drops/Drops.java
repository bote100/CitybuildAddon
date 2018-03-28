package net.bote.citybuild.drops;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Builder;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

import net.bote.citybuild.crates.Crates;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Drops {
	
	public static String prefix = "§bDrops §7| ";
	
	public static void openMenu(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9, "§bDrops");
		inv.setItem(0, createFireWork("§7Low-Drop", 64, Color.GRAY, 1));
		inv.setItem(1, createFireWork("§bUltra-Drop", 64, Color.AQUA, 1));
		inv.setItem(2, createFireWork("§6Champion-Drop", 64, Color.ORANGE, 1));
		inv.setItem(3, createFireWork("§cSuper-Drop", 64, Color.RED, 1));
		inv.setItem(4, createFireWork("§4§lMEGA-Drop", 64, Color.RED, 1));
		p.openInventory(inv);
	}
	
	public static ItemStack createFireWork(String dis, int anzahl, Color c, int power) {
		ItemStack i = new ItemStack(Material.FIREWORK, anzahl);
		FireworkMeta m = (FireworkMeta) i.getItemMeta();
		
		m.setDisplayName(dis);
		Builder e = FireworkEffect.builder();
		e.with(Type.BALL_LARGE);
		e.withColor(c);
		m.addEffect(e.build());
		
		m.setPower(power);
		i.setItemMeta(m);
		return i;
	}

	public static ItemStack createItem(Material mat, String displayname) {
		ItemStack i = new ItemStack(mat);
		ItemMeta m = i.getItemMeta();
		m.setDisplayName(displayname);
		i.setItemMeta(m);
		return i;
	}
	
	public static ItemStack createItem(Material mat, String displayname, int anzahl) {
		ItemStack i = new ItemStack(mat, anzahl);
		ItemMeta m = i.getItemMeta();
		m.setDisplayName(displayname);
		i.setItemMeta(m);
		return i;
	}
	
	public static ItemStack getRandomLowDrop() {
		Random r = new Random();
		int i = r.nextInt(11);
		
		switch (i) {
		case 0:
			return createItem(Material.DIAMOND, "§bDiamant");
		case 1:
			return createItem(Material.APPLE, "§cApfel");
		case 2:
			return new ItemStack(Material.WOOD, 16);
		case 3:
			return new ItemStack(Material.BREAD, 16);
		case 4:
			return createItem(Material.APPLE, "§cApfel");
		case 5:
			return new ItemStack(Material.EGG);
		case 6:
			return new ItemStack(Material.WOOD_HOE);
		case 7:
			return new ItemStack(Material.IRON_INGOT, 8);
		case 8:
			return createItem(Material.SNOW_BLOCK, "§fSchneeblock");
		case 9:
			return createItem(Material.STONE_PICKAXE, "§7Stein Spitzhacke");
		case 10:
			return createItem(Material.CARROT_ITEM, "§6Karotte");
		case 11:
			return createFireWork("§7Low-Drop", 64, Color.GRAY, 1);
		default:
			return new ItemStack(Material.ROTTEN_FLESH);
		}
	}
	
	public static ItemStack getRandomUltraDrop() {
		Random r = new Random();
		int i = r.nextInt(10);
		
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
			return new ItemStack(Material.CACTUS);
		case 5:
			return new ItemStack(Material.CARROT_ITEM);
		case 6:
			return new ItemStack(Material.IRON_PICKAXE);
		case 7:
			return new ItemStack(Material.IRON_INGOT, 16);
		case 8:
			return new ItemStack(Material.SNOW_BLOCK, 16);
		case 9:
			return new ItemStack(Material.BOOK, 16);
		case 10:
			return Drops.createFireWork("§bUltra-Drop", 4, Color.AQUA, 1);
		default:
			return new ItemStack(Material.ROTTEN_FLESH);
		}
	}
	
	
	
	public static ItemStack getRandomChampionDrop() {
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
			return createEnchatedItem(Material.IRON_CHESTPLATE, "§cChampion Brustplatte");
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
			return createFireWork("§6Champion-Drop", 1, Color.ORANGE, 1);
		case 10:
			return new ItemStack(Material.IRON_SWORD);
		default:
			return new ItemStack(Material.ROTTEN_FLESH);
		}
	}
	
	public static ItemStack getRandomSuperDrop() {
		Random r = new Random();
		int i = r.nextInt(10);
		
		switch (i) {
		case 0:
			return new ItemStack(Material.DIAMOND, 16);
		case 1:
			return createItem(Material.DIAMOND_CHESTPLATE, "§a§lSUPER §bChestplate");
		case 2:
			return new ItemStack(Material.WOOD, 16);
		case 3:
			return createItem(Material.DIAMOND_LEGGINGS, "§a§lSUPER §bHose");
		case 4:
			return createItem(Material.DIAMOND_BOOTS, "§a§lSUPER §bSchuhe");
		case 5:
			return new ItemStack(Material.EGG);
		case 6:
			return createToolItem(Material.IRON_PICKAXE, "§a§lSUPER §bSpitzhacke", 2);
		case 7:
			return new ItemStack(Material.IRON_INGOT, 8);
		case 8:
			return createItem(Material.DIAMOND_HELMET, "§a§lSUPER §bHelm");
		case 9:
			return new ItemStack(Material.BOOK);
		case 10:
			return createFireWork("§cSuper-Drop", 1, Color.RED, 1);
		default:
			return new ItemStack(Material.ROTTEN_FLESH);
		}
	}
	
	public static ItemStack getMegaDrop() {
		int i = 0;
		Random r = new Random();
		i = r.nextInt(10);
		
		switch (i) {
		case 0:
			return createItem(Material.BEACON, "§b§lLeuchtfeuer");
		case 1:
			return createEnchatedItem(Material.DIAMOND_CHESTPLATE, "§4§lMEGA§f-§4Chestplate");
		case 2:
			createFireWork("§cSuper-Drop", 8, Color.RED, 1);
		case 3:
			return createEnchatedItem(Material.DIAMOND_BOOTS, "§4§lMEGA§f-§4Schuhe");
		case 4:
			return createEnchatedItem(Material.DIAMOND_HELMET, "§4§lMEGA§f-§4Helm");
		case 5:
			// Belohnung Dragon Egg
			Random rnd = new Random();
			int lul = rnd.nextInt(2);
			switch (lul) {
			case 0:
				return new ItemStack(Material.GOLD_INGOT, 48);
			case 1:
				return new ItemStack(Material.DRAGON_EGG);
			default:
				return new ItemStack(Material.ROTTEN_FLESH);
			}
		case 6:
			return new ItemStack(Material.DIAMOND_PICKAXE);
		case 7:
			return new ItemStack(Material.DIAMOND_SWORD);
		case 8:
			return createEnchatedItem(Material.DIAMOND_LEGGINGS, "§4§lMEGA§f-§4Hose");
		case 9:
			return new ItemStack(Material.GOLDEN_APPLE, 16);
		case 10:
			return createFireWork("§6Champion-Drop", 8, Color.ORANGE, 1);
		default:
			return new ItemStack(Material.ROTTEN_FLESH);
		}
	}

	private static ItemStack createEnchatedItem(Material mat, String string) {
		ItemStack i = new ItemStack(mat);
		ItemMeta m = i.getItemMeta();
		m.setDisplayName(string);
		m.addEnchant(org.bukkit.enchantments.Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		i.setItemMeta(m);
		return i;
	}
	
	private static ItemStack createToolItem(Material mat, String string, int i) {
		ItemStack is = new ItemStack(mat);
		ItemMeta m = is.getItemMeta();
		m.setDisplayName(string);
		m.addEnchant(org.bukkit.enchantments.Enchantment.DIG_SPEED, i, true);
		is.setItemMeta(m);
		return is;
	}
	
	public static void sendPortMessage(Player p, Player target) {

		TextComponent ja = new TextComponent("§cteleportieren");
		ja.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/dropport " + target.getName()));
		ja.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§4Teleportieren auf eigene Gefahr!").create()));
		TextComponent msg = new TextComponent("§4§l" + target.getName() + " zündet einen MEGA-DROP! Klicke um dich zu ");
		msg.addExtra(ja);
		
		p.spigot().sendMessage(msg);
	}

}
