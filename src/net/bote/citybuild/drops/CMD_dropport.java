package net.bote.citybuild.drops;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bote.citybuild.main.Main;

public class CMD_dropport implements CommandExecutor {
	
	private Main plugin;

	public CMD_dropport(Main main) {
		// TODO Auto-generated constructor stub
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 1) {
				Player t = Bukkit.getPlayer(args[0]);
				p.teleport(t.getLocation());
				for(Player all : Bukkit.getOnlinePlayers()) {
					all.playEffect(t.getLocation(), Effect.EXPLOSION_HUGE, 10);
				}
			} else {
				p.kickPlayer("§cDon't do that!");
			}
		}
		return true;
	}

}
