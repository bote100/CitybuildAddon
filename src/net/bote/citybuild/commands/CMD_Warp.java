package net.bote.citybuild.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bote.citybuild.main.Main;
import net.bote.citybuild.warp.WarpManager;

public class CMD_Warp implements CommandExecutor {
	
	private Main plugin;

	public CMD_Warp(Main main) {
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
				if(args.length == 1) {
					String w = args[0];
					if(Main.getWarpManager().isWarpAlreadyExists(w)) {
						String spawn = args[0];
						String world = WarpManager.cfg.getString(spawn + ".world");
						double x = WarpManager.cfg.getDouble(spawn + ".x");
						double y = WarpManager.cfg.getDouble(spawn + ".y");
						double z = WarpManager.cfg.getDouble(spawn + ".z");
						double yaw = WarpManager.cfg.getDouble(spawn + ".yaw");
						double pitch = WarpManager.cfg.getDouble(spawn + ".pitch");
						Location loc = new Location(Bukkit.getWorld(world), x, y, z);
						loc.setYaw((float) yaw);
						loc.setPitch((float) pitch);
						p.teleport(loc);
					} else {
						p.sendMessage(WarpManager.wprefix+"§cDieser Warp existiert nicht!");
					}
				} else {
					p.sendMessage(Main.getWarpManager().wprefix+"§7Nutze: §e/warp <Warp>");
				}
		}
		return true;
	}

}
