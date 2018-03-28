package net.bote.citybuild.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bote.citybuild.main.Main;
import net.bote.citybuild.warp.WarpManager;

public class CMD_setWarp implements CommandExecutor {
	
	private Main plugin;
	
	public CMD_setWarp(Main main) {
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player p = (Player)sender;
		if(p.hasPermission("citybuild.warp.setwarp") || Main.getWarpManager().getCounts(p.getUniqueId().toString()) >= 1) {
			if(args.length == 1) {
				if(p.hasPermission("citybuild.warp.setwarp")) {
					Main.getWarpManager().createWarp(p, args[0]);
				} else {
					Main.getWarpManager().setCounts(p.getUniqueId().toString(), Main.getWarpManager().getCounts(p.getUniqueId().toString()) - 1);
					Main.getWarpManager().createWarp(p, args[0]);
				}
			} else {
				p.sendMessage(WarpManager.wprefix+"§eNutze: /setwarp <Warp-Name>");
			}
		} else {
			p.sendMessage(WarpManager.wprefix+"§cKein Recht!");
		}
		return true;
	}

}
